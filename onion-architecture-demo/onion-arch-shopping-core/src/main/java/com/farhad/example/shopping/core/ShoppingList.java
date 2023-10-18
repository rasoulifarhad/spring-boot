package com.farhad.example.shopping.core;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ShoppingList {

	private static final double SUBTOTAL_PRICE_BOUNDARY_FOR_FREE_SHIPPING = 100;
	private static final double STANDARD_SHIPPING_COSTS = 10;

	@Id
	private final UUID id = UUID.randomUUID();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(nullable = false)
	@Getter(value = AccessLevel.PRIVATE)
	private final Set<ShoppingItem> shoppingItems = new LinkedHashSet<>();

	public static ShoppingList of() {
		return new ShoppingList();
	}

	public void addItem(ShoppingItem shoppingItem) {
		shoppingItems.add(shoppingItem);
	}

	public int getSize() {
		return shoppingItems.size();
	}

	public void removeItem(ShoppingItem shoppingItem) {
		shoppingItems.remove(shoppingItem);
	}

	public ShoppingItem getItem(UUID shoppingItemId) {
		return shoppingItems.stream()
				.filter(s -> s.getId().equals(shoppingItemId))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Item with id: <" + id + "> not found!"));
	}

	public Double getTotalItems() {
		return shoppingItems.stream()
				.mapToDouble(s -> s.getQuantity())
				.sum();
	}

	public Double getSubTotalPrice() {
		return shoppingItems.stream()
				.mapToDouble(ShoppingItem::getSubTotalPrice)
				.sum();
	}

	public Double getShippingCosts() {
		if (getTotalItems() == 0) {
			return 0d;
		}

		if (getSubTotalPrice() >= SUBTOTAL_PRICE_BOUNDARY_FOR_FREE_SHIPPING) {
			return 0d;
		}

		return STANDARD_SHIPPING_COSTS;
	}

	public Double getTotalPrice() {
		return getSubTotalPrice() + getShippingCosts();
	}

}

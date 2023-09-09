package com.farhad.example.hexagonalorderdemo.shop.model.cart;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;
import com.farhad.example.hexagonalorderdemo.shop.model.money.Money;
import com.farhad.example.hexagonalorderdemo.shop.model.product.Product;
import com.farhad.example.hexagonalorderdemo.shop.model.product.ProductId;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Cart {
	
	private final CustomerId id;

	private final Map<ProductId, CartLineItem> lineItems = new LinkedHashMap<>();

	public Cart(CustomerId id) {
		Objects.requireNonNull(id);
		this.id = id;
	}

	public void addProduct(Product product, int quantity) throws NotEnoughItemsInStockException {
		lineItems.computeIfAbsent(product.id(), pid -> new CartLineItem(product) )
					.increaseQuantityBy(quantity, product.itemsInStock());
	}

	public CustomerId id() {
		return id;
	}

	public List<CartLineItem> lineItems() {
		return new ArrayList<>(this.lineItems.values());
	}
	public Money subTotal() {
		return 
			lineItems.values().stream()
				.map(CartLineItem::subTotal)
				.reduce(Money::add)
				.orElse(null);
	}

	public int numberOfItems() {
		return 
			lineItems.values().stream()
				.mapToInt(CartLineItem::quantity)
				.sum();		
	}
}

package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.farhad.example.coffeeorder.application.order.LineItem;
import com.farhad.example.coffeeorder.shared.Drink;
import com.farhad.example.coffeeorder.shared.Milk;
import com.farhad.example.coffeeorder.shared.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LineItemEntity {

	@Id
	@GeneratedValue
	private UUID id;

	@Enumerated
	@NotNull
	private Drink drink;

	@Enumerated
	@NotNull
	private Size size;

	@Enumerated
	@NotNull
	private Milk milk;

	@NotNull
	private Integer quantity;

	public LineItem toDomain() {
		return new LineItem(
			drink, 
			milk, 
			size, 
			quantity);
	}

	public static LineItemEntity fromDomain(LineItem lineItem) {
		LineItemEntity e = new LineItemEntity();
		e.setDrink(lineItem.getDrink());
		e.setMilk(lineItem.getMilk());
		e.setSize(lineItem.getSize());
		e.setQuantity(lineItem.getQuantity());
		return e;
	}
}

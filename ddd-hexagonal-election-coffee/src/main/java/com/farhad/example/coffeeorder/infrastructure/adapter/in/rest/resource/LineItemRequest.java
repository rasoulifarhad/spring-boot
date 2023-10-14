package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource;

import com.farhad.example.coffeeorder.application.order.LineItem;
import com.farhad.example.coffeeorder.shared.Drink;
import com.farhad.example.coffeeorder.shared.Milk;
import com.farhad.example.coffeeorder.shared.Size;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class LineItemRequest {
	
	private Drink drink;
	private Milk milk;
	private Size size;
	private int quantity;

	public LineItem toDomain() {
		return new LineItem(drink, milk, size, quantity);
	}

}

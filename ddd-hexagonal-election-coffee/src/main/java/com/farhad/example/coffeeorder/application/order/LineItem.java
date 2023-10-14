package com.farhad.example.coffeeorder.application.order;

import java.math.BigDecimal;

import com.farhad.example.coffeeorder.shared.Drink;
import com.farhad.example.coffeeorder.shared.Milk;
import com.farhad.example.coffeeorder.shared.Size;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class LineItem {
	private Drink drink;
	private Milk milk;
	private Size size;
	private int quantity;

	BigDecimal getCost() {

		BigDecimal price = BigDecimal.valueOf(4.0);
		if(size == Size.LARGE) {
			price = price.add(BigDecimal.ONE);
		}
		return price.multiply(BigDecimal.valueOf(quantity));
	}
	
}

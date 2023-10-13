package com.farhad.example.coffeeorder.application.order;

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
}

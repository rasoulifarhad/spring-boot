package com.farhad.example.coffeeorder.application.order;

import java.util.Arrays;

import com.farhad.example.coffeeorder.shared.Drink;
import com.farhad.example.coffeeorder.shared.Location;
import com.farhad.example.coffeeorder.shared.Milk;
import com.farhad.example.coffeeorder.shared.Size;

public class OrderTestFactory {
	

	public static Order anOrder() {
		return new Order(
			Location.TAKE_AWAY, 
			Arrays.asList(
				new LineItem(
					Drink.LATTE,
					Milk.WHOLE,
					Size.LARGE,
					1)));
	}

	public static Order aPaidOrder() {
		return anOrder()
				.markPaid();
	}

	public static Order anOrderInPreparation() {
		return aPaidOrder()
				.markBeingPrepared();
	}

	public static Order aReadyOrder() {
		return aPaidOrder()
					.markPrepared();
	}
}

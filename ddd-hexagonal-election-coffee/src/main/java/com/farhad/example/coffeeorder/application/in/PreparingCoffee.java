package com.farhad.example.coffeeorder.application.in;

import java.util.UUID;

import com.farhad.example.coffeeorder.application.order.Order;

public interface PreparingCoffee {
	
	Order startPreparingOrder(UUID orderId);
	Order finishPreparingOrder(UUID orderId);
}

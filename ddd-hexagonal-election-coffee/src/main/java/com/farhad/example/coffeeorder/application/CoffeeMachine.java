package com.farhad.example.coffeeorder.application;

import java.util.UUID;

import com.farhad.example.coffeeorder.application.in.PreparingCoffee;
import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.architecture.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class CoffeeMachine implements PreparingCoffee {

	private final Orders orders;
	@Override
	public Order startPreparingOrder(UUID orderId) {
		Order order = orders.findByOrderId(orderId);

		return orders.save(order.markBeingPrepared());
	}

	@Override
	public Order finishPreparingOrder(UUID orderId) {
		Order order = orders.findByOrderId(orderId);

		return orders.save(order.markPrepared());
	}
	
}

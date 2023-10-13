package com.farhad.example.coffeeorder.application.order;

import java.util.List;
import java.util.UUID;

import com.farhad.example.coffeeorder.shared.Location;
import com.farhad.example.coffeeorder.shared.Status;

public class Order {
	
	private UUID id = UUID.randomUUID();

	private final Location location;

	private final List<LineItem> items;

	private Status status = Status.PAYMENT_EXPECTED;

	public Order markPaid() {
		if(status != Status.PAYMENT_EXPECTED) {
			throw new IllegalStateException("Order is Already paid");
		}
		status = Status.PAID;
		return this;
	}

	public Order markBeingPrepared() {
		return null;
	}
}

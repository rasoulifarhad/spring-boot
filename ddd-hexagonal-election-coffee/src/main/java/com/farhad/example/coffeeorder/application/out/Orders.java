package com.farhad.example.coffeeorder.application.out;

import java.util.UUID;

import com.farhad.example.coffeeorder.application.order.Order;

public interface Orders {
	Order save(Order order);
	Order findByOrderId(UUID orderId) throws OrderNotFound;
	void deleteById(UUID orderId);

}

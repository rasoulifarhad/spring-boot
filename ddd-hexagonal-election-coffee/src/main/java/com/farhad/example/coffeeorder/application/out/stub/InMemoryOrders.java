package com.farhad.example.coffeeorder.application.out.stub;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.OrderNotFound;
import com.farhad.example.coffeeorder.application.out.Orders;

public class InMemoryOrders implements Orders{

    private final Map<UUID, Order> entities = new HashMap<>();

	@Override
	public Order save(Order order) {
		entities.put(order.getId(), order);
		return order;
	}

	@Override
	public Order findByOrderId(UUID orderId) throws OrderNotFound {
		Order order = entities.get(orderId);
		if (order == null) {
			throw new OrderNotFound();
		}
		return order;
	}

	@Override
	public void deleteById(UUID orderId) {
		entities.remove(orderId);
	}
	
}

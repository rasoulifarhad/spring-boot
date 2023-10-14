package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;


import java.util.UUID;

import org.springframework.stereotype.Component;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.OrderNotFound;
import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.entity.OrderEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrdersJpaAdapter implements Orders {

	private final OrderJpaRepository orderJpaRepository;


	@Override
	public Order save(Order order) {
		return orderJpaRepository.save(
									OrderEntity.fromDomain(order))
								.toDomain();
	}

	@Override
	public Order findByOrderId(UUID orderId) throws OrderNotFound {
		return orderJpaRepository.findById(orderId)
					.map(OrderEntity::toDomain)
					.orElseThrow(() -> new IllegalStateException("Order find error"));
	}

	@Override
	public void deleteById(UUID orderId) {
		orderJpaRepository.deleteById(orderId);
	}
	
}

package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;


import java.util.UUID;

import org.springframework.stereotype.Component;

import com.farhad.example.coffeeorder.application.order.Order;
import com.farhad.example.coffeeorder.application.out.OrderNotFound;
import com.farhad.example.coffeeorder.application.out.Orders;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrdersJpaAdapter implements Orders {

	private final OrderJpaRepository orderJpaRepository;

	
	@Override
	public Order save(Order order) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public Order findByOrderId(UUID orderId) throws OrderNotFound {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByOrderId'");
	}

	@Override
	public void deleteById(UUID orderId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
	}
	
}

package com.farhad.example.storedemo.store_core.orders;

import java.util.List;

import com.farhad.example.storedemo.store_core.security.PrincipalUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderQueryService {
	private final OrderRepository orderRepository;

	public List<Order> retrieveOrdeersForUser(PrincipalUser user) {
		return orderRepository.listOrdersForUser(user);
	}
}

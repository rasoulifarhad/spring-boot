package com.farhad.example.storedemo.store_core.orders;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class OrderAdminService {
	
	private final OrderRepository orderRepository;

	public void purgeOrders() {
		log.warn("Performing a very dangerous operation");
		orderRepository.removeAllOrders();
		log.info("Orders purged");
	}
}

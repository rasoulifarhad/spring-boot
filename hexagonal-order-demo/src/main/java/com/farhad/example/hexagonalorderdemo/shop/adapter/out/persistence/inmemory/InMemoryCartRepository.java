package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.inmemory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public class InMemoryCartRepository implements CartRepository {

	private final Map<CustomerId, Cart> carts = new ConcurrentHashMap<>();
	
	@Override
	public Optional<Cart> findByCustomerId(CustomerId customerId) {
		return Optional.ofNullable(carts.get(customerId));
	}

	@Override
	public void save(Cart cart) {
		carts.put(cart.id(), cart);
	}

	@Override
	public void deleteById(CustomerId customerId) {
		carts.remove(customerId);
	}
	
}

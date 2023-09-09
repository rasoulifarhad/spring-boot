package com.farhad.example.hexagonalorderdemo.shop.adapter.out.persistence.inmemory;

import java.util.Optional;

import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public class InMemoryCartRepository implements CartRepository {

	@Override
	public Optional<Cart> findByCustomerId(CustomerId customerId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByCustomerId'");
	}

	@Override
	public Cart save(Cart cart) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public void deleteById(CustomerId customerId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
	}
	
}

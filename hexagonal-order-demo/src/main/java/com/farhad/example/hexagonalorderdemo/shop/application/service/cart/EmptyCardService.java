package com.farhad.example.hexagonalorderdemo.shop.application.service.cart;

import java.util.Objects;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.EmptyCartUseCase;
import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmptyCardService implements EmptyCartUseCase {

	private final CartRepository cartRepository;

	@Override
	public void emptyCart(CustomerId customerId) {
		Objects.requireNonNull(customerId, "customerId must not be null");
		cartRepository.deleteById(customerId);
	}
	
}

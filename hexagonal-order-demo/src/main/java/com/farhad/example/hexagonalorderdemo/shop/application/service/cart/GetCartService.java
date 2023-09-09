package com.farhad.example.hexagonalorderdemo.shop.application.service.cart;

import java.util.Objects;

import com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart.GetCartUseCase;
import com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence.CartRepository;
import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetCartService implements GetCartUseCase {

	private final CartRepository cartRepository;

	@Override
	public Cart getCart(CustomerId customerId) {
		Objects.requireNonNull(customerId, "customerId must not be null");
		return	cartRepository
					.findByCustomerId(customerId)
					.orElseGet(() -> new Cart(customerId));
	}
	
}

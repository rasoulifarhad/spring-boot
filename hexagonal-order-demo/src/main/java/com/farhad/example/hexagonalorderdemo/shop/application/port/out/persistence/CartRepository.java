package com.farhad.example.hexagonalorderdemo.shop.application.port.out.persistence;

import java.util.Optional;

import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public interface CartRepository {

	Optional<Cart> findByCustomerId(CustomerId customerId);

	void save(Cart cart);

	void deleteById(CustomerId customerId);

}

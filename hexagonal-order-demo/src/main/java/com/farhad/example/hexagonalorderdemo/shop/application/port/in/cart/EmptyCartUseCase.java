package com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart;

import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public interface EmptyCartUseCase {
	void emptyCart(CustomerId customerId);
}

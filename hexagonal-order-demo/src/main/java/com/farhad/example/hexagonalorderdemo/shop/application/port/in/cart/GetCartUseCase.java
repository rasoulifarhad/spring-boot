package com.farhad.example.hexagonalorderdemo.shop.application.port.in.cart;

import com.farhad.example.hexagonalorderdemo.shop.model.cart.Cart;
import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public interface GetCartUseCase {
	
	Cart getCart(CustomerId customerId);
}

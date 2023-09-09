package com.farhad.example.hexagonalorderdemo.shop.model.cart;

import java.util.concurrent.ThreadLocalRandom;

import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public class TestCartFactory {
	
	public static Cart emptyCartForRandomCustomer() {
		return new Cart(new CustomerId(ThreadLocalRandom.current().nextInt(1_000_000)));
	}
}

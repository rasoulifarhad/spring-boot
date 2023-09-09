package com.farhad.example.hexagonalorderdemo.shop.model.customer;

import lombok.Value;

@Value
public class CustomerId {

	private final int value;

	public CustomerId(int value) {
		if(value < 1) {
			throw new IllegalArgumentException("valie must be positiveinteger");
		}
		this.value = value;
	}
}

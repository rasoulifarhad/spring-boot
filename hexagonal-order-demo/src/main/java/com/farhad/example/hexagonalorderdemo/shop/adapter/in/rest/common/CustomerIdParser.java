package com.farhad.example.hexagonalorderdemo.shop.adapter.in.rest.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.farhad.example.hexagonalorderdemo.shop.model.customer.CustomerId;

public final class CustomerIdParser {
	private CustomerIdParser() {}

	public static CustomerId parseCustomerId(String customerIdString) {
		try {
			return new CustomerId(Integer.parseInt(customerIdString));
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid 'customerId'");
		}
	}

}

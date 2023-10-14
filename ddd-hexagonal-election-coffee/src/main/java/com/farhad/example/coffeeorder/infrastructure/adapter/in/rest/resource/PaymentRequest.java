package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class PaymentRequest {
	
	@NotNull 
	private String cardHolderName;
	@NotNull 
	private String cardNumber;
	@NotNull 
	private Integer expiryMonth;
	@NotNull 
	private Integer expiryYear;
}

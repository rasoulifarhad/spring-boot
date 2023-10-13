package com.farhad.example.coffeeorder.application.payment;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class Payment {
	
	private UUID orderId;
	private CreditCard creditCard;
	private LocalDate paid;
}

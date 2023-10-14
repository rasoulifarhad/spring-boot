package com.farhad.example.coffeeorder.application.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Value;

@Value
public class Receipt {

	private BigDecimal amount;
	private LocalDate paid;

	public Receipt(BigDecimal amount, LocalDate paid) {
		this.amount = amount;
		this.paid = paid;
	}
	
}

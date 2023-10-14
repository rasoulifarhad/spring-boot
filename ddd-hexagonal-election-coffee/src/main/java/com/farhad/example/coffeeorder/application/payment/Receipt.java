package com.farhad.example.coffeeorder.application.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Value;

@Value
public class Receipt {

	private BigDecimal cost;
	private LocalDate paid;

	public Receipt(BigDecimal cost, LocalDate paid) {
		this.cost = cost;
		this.paid = paid;
	}
	
}

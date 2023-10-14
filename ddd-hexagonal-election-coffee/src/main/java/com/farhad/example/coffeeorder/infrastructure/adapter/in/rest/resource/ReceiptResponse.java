package com.farhad.example.coffeeorder.infrastructure.adapter.in.rest.resource;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.farhad.example.coffeeorder.application.payment.Receipt;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ReceiptResponse {
	
	private BigDecimal amount;
	private LocalDate paid;

    public static ReceiptResponse fromDomain(Receipt receipt) {
        return new ReceiptResponse(receipt.getAmount(), receipt.getPaid());	
	}
}

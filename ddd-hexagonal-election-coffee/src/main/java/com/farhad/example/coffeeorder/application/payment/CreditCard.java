package com.farhad.example.coffeeorder.application.payment;

import java.time.Month;
import java.time.Year;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class CreditCard {
	private String cardHolderName;
    private String cardNumber;
    private Month expiryMonth;
    private Year expiryYear;
}

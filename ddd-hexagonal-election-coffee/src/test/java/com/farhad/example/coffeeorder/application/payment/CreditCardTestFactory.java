package com.farhad.example.coffeeorder.application.payment;

import java.time.Month;
import java.time.Year;

public class CreditCardTestFactory {
	public static CreditCard aCreditCard() {
		return new CreditCard("Test", "123456", Month.JANUARY, Year.of(2023));
	}
}

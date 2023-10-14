package com.farhad.example.coffeeorder.application.payment;

import static com.farhad.example.coffeeorder.application.payment.CreditCardTestFactory.aCreditCard;

import java.time.LocalDate;

import com.farhad.example.coffeeorder.application.order.Order;

public class PaymentTestFactory {
	public static Payment aPaymentForOrder(Order order) {
		return new Payment(order.getId(), aCreditCard(), LocalDate.now());
	}
}

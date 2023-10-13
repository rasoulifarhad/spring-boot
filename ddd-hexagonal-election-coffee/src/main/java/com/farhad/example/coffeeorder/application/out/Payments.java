package com.farhad.example.coffeeorder.application.out;

import java.util.UUID;

import com.farhad.example.coffeeorder.application.payment.Payment;

public interface Payments {
	Payment save(Payment payment);
	Payment findPaymentByOrderId(UUID orderId);
}

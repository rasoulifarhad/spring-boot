package com.farhad.example.coffeeorder.application.out;

import java.util.UUID;

public interface Payments {
	Payment save(Payment payment);
	Payment findPaymentByOrderId(UUID orderId);
}

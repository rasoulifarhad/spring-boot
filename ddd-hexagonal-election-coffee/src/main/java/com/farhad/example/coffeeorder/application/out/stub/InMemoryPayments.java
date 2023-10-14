package com.farhad.example.coffeeorder.application.out.stub;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.farhad.example.coffeeorder.application.out.Payments;
import com.farhad.example.coffeeorder.application.payment.Payment;

public class InMemoryPayments implements Payments {

    private final Map<UUID, Payment> entities = new HashMap<>();

	@Override
	public Payment save(Payment payment) {
		entities.put(payment.getOrderId(), payment);
		return payment;
	}

	@Override
	public Payment findPaymentByOrderId(UUID orderId) {
		return entities.get(orderId);
	}
	
}

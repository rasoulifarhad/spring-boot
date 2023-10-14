package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.farhad.example.coffeeorder.application.out.Payments;
import com.farhad.example.coffeeorder.application.payment.Payment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PaymentJpaAdapter implements Payments {

	private final PaymentJpaRepository paymentJpaRepository;
	@Override
	public Payment save(Payment payment) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public Payment findPaymentByOrderId(UUID orderId) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findPaymentByOrderId'");
	}
	
}

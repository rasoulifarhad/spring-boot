package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.farhad.example.coffeeorder.application.out.Payments;
import com.farhad.example.coffeeorder.application.payment.Payment;
import com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance.entity.PaymentEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PaymentJpaAdapter implements Payments {

	private final PaymentJpaRepository paymentJpaRepository;
	@Override
	public Payment save(Payment payment) {
		return paymentJpaRepository.save(PaymentEntity.fromDomain(payment)).toDomain();
	}

	@Override
	public Payment findPaymentByOrderId(UUID orderId) {
		return paymentJpaRepository.findById(orderId)
					.map(PaymentEntity::toDomain)
				.orElseThrow(() -> new IllegalStateException("payment find error")) ;
	}
	
}

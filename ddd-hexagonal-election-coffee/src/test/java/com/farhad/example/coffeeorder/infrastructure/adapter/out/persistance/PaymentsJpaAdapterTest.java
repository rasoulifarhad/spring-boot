package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.farhad.example.coffeeorder.application.out.Payments;

@PersistenceTest
public class PaymentsJpaAdapterTest {
	
	@Autowired
	private Payments payments;

	@Test
	void creatingPaymentReturnsPersistedPayment() {

	}

	@Test
	void findingPreviouslyPersistedPaymentReturnsDetails() {

	}

	@Test
	void findingNonExistingPaymentThrowsException() {
		
	}
}

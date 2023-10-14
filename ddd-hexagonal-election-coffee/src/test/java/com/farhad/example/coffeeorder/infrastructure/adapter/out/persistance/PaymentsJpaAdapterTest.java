package com.farhad.example.coffeeorder.infrastructure.adapter.out.persistance;

import static com.farhad.example.coffeeorder.application.payment.CreditCardTestFactory.aCreditCard;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.farhad.example.coffeeorder.application.out.Payments;
import com.farhad.example.coffeeorder.application.payment.CreditCard;
import com.farhad.example.coffeeorder.application.payment.Payment;
@PersistenceTest
public class PaymentsJpaAdapterTest {
	
	@Autowired
	private Payments payments;

	@Test
	void creatingPaymentReturnsPersistedPayment() {
        LocalDate now = LocalDate.now();
        CreditCard creditCard = aCreditCard();
        Payment payment = new Payment(UUID.randomUUID(), creditCard, now);

        Payment persistedPayment = payments.save(payment);

        assertThat(persistedPayment.getCreditCard()).isEqualTo(creditCard);
        assertThat(persistedPayment.getPaid()).isEqualTo(now);
	}

	@Test
	@Sql("classpath:data/payment.sql")
	void findingPreviouslyPersistedPaymentReturnsDetails() {
        Payment payment = payments.findPaymentByOrderId(UUID.fromString("a41c9394-3aa6-4484-b0b4-87de55fa2cf4"));

        CreditCard expectedCreditCard = new CreditCard("Michael Faraday", "11223344", Month.JANUARY, Year.of(2023));

        assertThat(payment.getCreditCard()).isEqualTo(expectedCreditCard);
	}

	@Test
	void findingNonExistingPaymentThrowsException() {

	}
}

package com.farhad.example.coffeeorder.infrastructure.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.farhad.example.coffeeorder.application.out.Orders;
import com.farhad.example.coffeeorder.application.out.Payments;
import com.farhad.example.coffeeorder.application.out.stub.InMemoryOrders;
import com.farhad.example.coffeeorder.application.out.stub.InMemoryPayments;

@TestConfiguration
@Import(DomainConfig.class)
public class DomainConfigTest {

	@Bean
	public Orders orders() {
		return new InMemoryOrders();
	}

	@Bean
	public Payments payments() {
		return new InMemoryPayments();
	}

}

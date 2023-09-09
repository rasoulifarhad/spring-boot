package com.farhad.example.hexagonalorderdemo.shop.model.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CustomerIdTest {

	@ParameterizedTest
	@ValueSource(ints = {-100, -1, 0})
	public void given_aValueLessThan1_when_newCustomerId_then_throwsException(int value) {

		assertThrows(
			IllegalArgumentException.class, 
			() -> new CustomerId(value));
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 1_000, 1_234})
	public void given_aValueGreaterOrEqualTo1_when_newCustomerId_then_succeeds(int value) {

		CustomerId customerId = new CustomerId(value);

		assertThat(customerId.getValue()).isEqualTo(value);
	}

}

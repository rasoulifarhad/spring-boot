package com.farhad.example.discount.application;

import java.math.BigDecimal;
import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "amount")
@ToString
public class Rate {
	private final Amount amount;

	private Rate(Amount amount) {
		Objects.requireNonNull(amount);
		if (amount.isGreaterThan(Amount.parse("1.0"))) {
			throw new IllegalArgumentException("Amount cannot be greater than one");
		}
		this.amount = amount;
	}

	public static Rate parse(String strs ) {
		return new Rate(Amount.parse(strs));
	}

	public BigDecimal getValue() {
		return amount.getValue();
	}
}

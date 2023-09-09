package com.farhad.example.hexagonalorderdemo.shop.model.money;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

	private final BigDecimal amount;

	public Money(BigDecimal value) {
		Objects.requireNonNull(value, "amount must not be null");
		if(value.scale() > 2 ) {
			throw new IllegalArgumentException("scale of amount is greater than 2");
		}
		this.amount = value;
	}

	public Money of(int mayor, int minor) {
		int scale = 2;
		return new Money(BigDecimal.valueOf(mayor).add(BigDecimal.valueOf(minor, scale)));
	}

	public Money add(Money augend) {
		return new Money(amount.add(augend.amount));
	}

	public Money multiply(int multiplicant) {
		return new Money(amount.multiply(BigDecimal.valueOf(multiplicant)));
	}
}

package com.farhad.example.hexagonalorderdemo.shop.model.money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import lombok.Value;

@Value
public class Money {

	private final Currency currency;
	private final BigDecimal amount;

	public Money(Currency currency, BigDecimal amount) {
		Objects.requireNonNull(currency, "currency must not be null");
		Objects.requireNonNull(amount, "amount must not be null");
		if(amount.scale() > currency.getDefaultFractionDigits() ) {
			throw new IllegalArgumentException(
				String.format("scale of amount %s is greater than " 
								+ " the number of fraction digits used with currency %s", amount, currency));
		}
		this.amount = amount;
		this.currency = currency;
	}

	public static Money of(Currency currency, int mayor, int minor) {
		int scale = currency.getDefaultFractionDigits();
		return new Money(
			currency, 
			BigDecimal.valueOf(mayor).add(BigDecimal.valueOf(minor, scale)));
	}

	public Money add(Money augend) {
		if (!this.currency.equals(augend.currency)) {
			throw new IllegalArgumentException(
				String.format("Currency %s of augend dose not match this money's  currency %s",
									augend.currency, this.currency));
		}

		return new Money(currency, amount.add(augend.amount));
	}

	public Money multiply(int multiplicant) {
		return new Money(currency, amount.multiply(BigDecimal.valueOf(multiplicant)));
	}
}

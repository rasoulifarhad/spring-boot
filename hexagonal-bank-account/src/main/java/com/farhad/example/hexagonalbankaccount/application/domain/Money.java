package com.farhad.example.hexagonalbankaccount.application.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import lombok.Value;

@Value
public class Money {

	private final static Currency DEF_CURRENCY = Currency.getInstance("USD");
	private final static Currency EUR = Currency.getInstance("EUR");
	private final static Currency USD = Currency.getInstance("USD");

	private Currency currency;
	private BigDecimal amount;

	public Money(Currency currency, BigDecimal amount) {
		Objects.requireNonNull(currency, "currency mus not be null");
		Objects.requireNonNull(amount, "amount mus not be null");
		if (amount.signum() == -1) {
			throw new IllegalArgumentException("amount must be positive");
		}
		if (amount.scale() > currency.getDefaultFractionDigits()) {
			throw new IllegalArgumentException(
				String.format("scale of amount %s is greater than " +
								"the number of fraction digits used with currency %s",amount, currency));
		}
		this.amount = amount;
		this.currency = currency;
	}
	public Money(String currencyString, BigDecimal amount) {
		this(Currency.getInstance(currencyString), amount);
	}

	public static Money of(Currency currency, int major, int minor) {
		Objects.requireNonNull(currency, "Currency must not be null");
		int scale = currency.getDefaultFractionDigits();
		return new Money(currency, BigDecimal.valueOf(major).add(BigDecimal.valueOf(minor, scale)));
	}

	public static Money euro(int major, int minor) {
		return of(EUR, major, minor);
	}

	public static Money dollar(int major, int minor) {
		return of(USD, major, minor);
	}

	// (augend) + (addend) = (total)
	public Money add(Money addend) {
		Objects.requireNonNull(addend, "Mony must not be null");
		if (!hasSameCurrency(addend)) {
			throw new IllegalArgumentException("currency must be same.");
		}
		return new Money(currency, amount.add(addend.amount));
	}

	// (minuend) − (subtrahend) = (difference)

	public Money sub(Money subtrahend) {
		Objects.requireNonNull(subtrahend, "Mony must not be null");
		if (!hasSameCurrency(subtrahend)) {
			throw new IllegalArgumentException("currency must be same.");
		}
		BigDecimal difference = amount.subtract(subtrahend.amount);
		if(difference.signum() == -1 ) {
			throw new IllegalArgumentException("Diference can not be negative");
		}
		return new Money(currency, difference);
	}

	// (multiplier) × (multiplicand) = (product)
	public Money multiply(int multiplicand) {
		return new Money(this.currency, this.amount.multiply(BigDecimal.valueOf(multiplicand)));
	}

	public boolean hasSameCurrency(Money other) {
		Objects.requireNonNull(other, "Mony must not be null");
		return this.currency.getCurrencyCode().equals(other.currency.getCurrencyCode());
	}

}

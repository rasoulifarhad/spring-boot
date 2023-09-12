package com.farhad.example.storedemo.store_core.money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import lombok.Value;

@Value
public class Money {

	private final static Currency DEF_CURRENCY = Currency.getInstance("USD");
	private final static Currency EUR = Currency.getInstance("EUR");
	private final static Currency USD = Currency.getInstance("USD");

	private final Currency currency;
	private final BigDecimal amount;

	public Money(String currencyString, BigDecimal amount) {
		this(Currency.getInstance(currencyString), amount);
	}

	public Money(Currency currency, BigDecimal amount) {
		Objects.requireNonNull(currency, "currency must not be null");
		Objects.requireNonNull(amount, "amount must not be null");
		if(amount.scale() > currency.getDefaultFractionDigits()) {
			throw new IllegalArgumentException(
				String.format("scale of amount %s is greater than " +
								"the number of fraction digits used with currency %s",amount, currency));
		}
		this.currency = currency;
		this.amount = amount;
	}

	public static Money of(Currency currency, int major, int minor) {
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
		if(!this.currency.equals(addend.currency)) {
			throw new IllegalArgumentException(
					String.format("currency %s of addend dose not match this money's currency %s", 
			addend.currency, this.currency));
		}
		return new  Money(this.currency, this.amount.add(addend.amount));
	}

	// (multiplier) × (multiplicand) = (product)
	public Money multiply(int multiplicand) {
		return new Money(this.currency, this.amount.multiply(BigDecimal.valueOf(multiplicand)));
	}
}

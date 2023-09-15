package com.farhad.example.hexagonalbankaccount.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class Money implements Serializable{

	private static int scale = 2;

	private BigDecimal amount;

	public Money( BigDecimal amount) {
		Objects.requireNonNull(amount, "amount mus not be null");
		if (amount.signum() == -1) {
			throw new IllegalArgumentException("amount must be positive");
		}
		this.amount = amount;
	}

	public static Money of(int major, int minor) {
		return new Money(BigDecimal.valueOf(major).add(BigDecimal.valueOf(minor, scale)));
	}

	// (augend) + (addend) = (total)
	public Money add(Money addend) {
		Objects.requireNonNull(addend, "Mony must not be null");
		return new Money(amount.add(addend.amount));
	}

	// (minuend) − (subtrahend) = (difference)

	public Money sub(Money subtrahend) {
		Objects.requireNonNull(subtrahend, "Mony must not be null");
		BigDecimal difference = amount.subtract(subtrahend.amount);
		if(difference.signum() == -1 ) {
			throw new IllegalArgumentException("Diference can not be negative");
		}
		return new Money(difference);
	}

	// (multiplier) × (multiplicand) = (product)
	public Money multiply(int multiplicand) {
		return new Money(this.amount.multiply(BigDecimal.valueOf(multiplicand)));
	}

}

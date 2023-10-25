package com.farhad.example.discount.application;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "value")
@ToString
public class Amount {
	
	private BigDecimal value;

	public Amount(BigDecimal value) {
		requireNonNull(value);
		if (value.signum() == -1 ) {
			throw new IllegalArgumentException("Value ("+  value+ ") can not be less than zero ");
		}

		if (value.scale() > 2 ) {
			throw new IllegalArgumentException("The number of decimal places ("+value.scale()+") cannot be greater than 2 digits");
		}
		this.value = value.setScale(2, RoundingMode.HALF_UP);
	}

	public static Amount parse(String chars) {
		requireNonNull(chars);
		if (chars.trim().isEmpty()) {
			throw new IllegalArgumentException("Characters must be provided");
		}
		BigDecimal value = null;
		try {
			value = new BigDecimal(chars);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Characters ("+chars+") don't match a valid number format",e);
		}
		return new Amount(value);
		
	}
	public boolean isEqualsTo(Amount amount) {
		requireNonNull(amount);
		return value.compareTo(amount.getValue()) == 0;
	}

	public boolean isGreaterThan(Amount amount) {
		requireNonNull(amount);
		return value.compareTo(amount.getValue()) > 0;
	}
	
	public boolean isGreaterThanOrEqualTo(Amount amount) {
		requireNonNull(amount);
		return value.compareTo(amount.getValue()) >= 0;
	}
	public Amount multiply(Rate rate) {
		requireNonNull(rate);
		BigDecimal res = this.value.multiply(rate.getValue()).setScale(2, RoundingMode.HALF_UP);
		return new Amount(res);
	}

	
}

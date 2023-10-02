package com.farhad.example.ddd_example.sharedkernel.domain.financial;

import static java.util.Objects.requireNonNull;

import java.math.BigDecimal;
import java.util.Currency;

import com.farhad.example.ddd_example.sharedkernel.domain.base.ValueObject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Money implements ValueObject {
    
    private final Currency currency;

    private final BigDecimal amount; 

    public Money(Currency currency, BigDecimal amount) {
        requireNonNull(currency, "currency must not be null");
        requireNonNull(amount, "amount must not be null");
		if(amount.scale() > currency.getDefaultFractionDigits() ) {
			throw new IllegalArgumentException(
				String.format("scale of amount %s is greater than " 
								+ " the number of fraction digits used with currency %s", amount, currency));
        }
        this.currency = currency;
        this.amount = amount;     
    }

    public static Money of(Currency currency, BigDecimal amount) {
        return new Money(currency, amount);
    }

    public static Money of(Currency currency, int mayor, int minor) {
        requireNonNull(currency, "currency must not be null");
		int scale = currency.getDefaultFractionDigits();
		return new Money(
			currency, 
			BigDecimal.valueOf(mayor).add(BigDecimal.valueOf(minor, scale)));

    }

    public Money add(@NonNull Money augend) {
		isCurrencySame(augend);
		return new Money(currency, amount.add(augend.amount));
    }

    public Money sub(@NonNull Money subtrahend) {
		isCurrencySame(subtrahend);
		return new Money(currency, amount.subtract(subtrahend.amount));
    }

    private void isCurrencySame(Money other) {
        if (!this.currency.equals(other.currency)) {
			throw new IllegalArgumentException(
				String.format("Currency %s of augend dose not match this money's  currency %s",
									other.currency, this.currency));
		}
    }

    public Money multiply(@NonNull Integer multiplicand) {
		return new Money(currency, amount.multiply(BigDecimal.valueOf(multiplicand)));
    }
}

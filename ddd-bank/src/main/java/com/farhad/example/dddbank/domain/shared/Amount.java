package com.farhad.example.dddbank.domain.shared;

import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Amount implements Comparable<Amount>{
    
    public static final Amount ZERO = new Amount(0, 0);

    @Getter
    private long value;

    public Amount(final int mayor, final int minor) {
        final double minorAsDouble = 100.0 * mayor + minor;
        this.value = Math.round(minorAsDouble);
    }

    public Amount(final double mayor) {
      
        if(Double.isNaN(mayor) || mayor > maxValue() || mayor < minValue()) {
            throw new RuntimeException();
        }
        this.value = Math.round(mayor * 100d);
    }
    
    public Amount plus(final Amount other) {
        final double result = this.toDouble() + other.toDouble();
        return new Amount(result);
    }

    public Amount minus(final Amount other) {
        final double result = this.toDouble() - other.toDouble();
        return new Amount(result);
    }    

    public Amount times(final double factor) {
        final double result = this.toDouble() * factor;
        return new Amount(result);
    }    

    private Double toDouble() {
        return value /100.0;
    }

    public static double maxValue() {
		return 9E13;
	}


	public static double minValue() {
		return -maxValue();
	}

    public int signum() {
        return compareTo(ZERO);
    }
    public boolean isGreaterThan(Amount other) {
        return compareTo(other) > 0;
    }

    @Override
    public int compareTo(Amount other) {
        Objects.requireNonNull(other);
        return this.toDouble().compareTo(other.toDouble());
    }    
}

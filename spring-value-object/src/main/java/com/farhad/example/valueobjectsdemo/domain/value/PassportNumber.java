package com.farhad.example.valueobjectsdemo.domain.value;

import javax.validation.ConstraintViolationException;

import lombok.Value;

@Value
public class PassportNumber {

    private int value;

    public PassportNumber(int value) {
        this.value = validatePassportNumber(value);
    }

    private static int validatePassportNumber(int value) {
        if ( !(value >= 0 && value <= 999999)  ) {
            throw new ConstraintViolationException("Passport number is not valid: " + value, null);
        }
        return value;
    }

    public static PassportNumber parse(String value) {
        return new PassportNumber(Integer.valueOf(value));
    }
    
    @Override
    public String toString() {
        return String.format("%06d", value);
    }

}

package com.farhad.example.dddbank.domain.model;

import static java.util.Objects.requireNonNull;

import lombok.Value;

@Value
public class AccountNo {
    
    private long number;

    public AccountNo(final Long number) {
        requireNonNull(number);
        if(number < 0 ){
            throw new IllegalArgumentException("Account number can not be negative: " + number);
        }
        this.number = number.longValue();
    }

    public AccountNo(final String number) {
        requireNonNull(number);

        if(!number.matches("\\d+") ){
            throw new IllegalArgumentException("Account number mst be positive number: " + number);
        }
        this.number = Long.parseLong(number);
    }
    
}

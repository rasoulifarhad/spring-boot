package com.farhad.example.valueobjectsdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class PassportNumber {

    private int value;

    @Override
    public String toString() {
        return String.format("%o6d", value);
    }

}

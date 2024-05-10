package com.farhad.example.dddorderexample.domain.model;

import java.math.BigDecimal;

import lombok.Value;

@Value
public class MonetaryValue {

    private final BigDecimal amount;
    private final String unit;
}

package com.farhad.example.dddbank.infrastructure.persistence.rest;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class DepositCommand {
    
    private final Long accountNo;
    private final double amount;
}

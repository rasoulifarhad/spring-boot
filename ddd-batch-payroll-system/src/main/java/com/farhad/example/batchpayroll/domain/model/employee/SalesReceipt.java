package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class SalesReceipt {
    private Instant date;
    private double amount;
}

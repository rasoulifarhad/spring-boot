package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class SalesReceipt {
    private LocalDate date;
    private double amount;
}

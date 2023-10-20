package com.farhad.example.batchpayroll.domain.command.employee;

import java.time.Instant;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Value
@Builder
public class PayCheck {

    private final Instant payDate;
    private int empId;
    private double grossPay;
    private double deduction;
    private double netPay;
    private String disposition;
    public String getDisposition;

}

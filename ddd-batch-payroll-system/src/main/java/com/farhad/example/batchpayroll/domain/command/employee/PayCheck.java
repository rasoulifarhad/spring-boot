package com.farhad.example.batchpayroll.domain.command.employee;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PayCheck {


    private LocalDate payPeriodStart;
    private LocalDate payDate;
    private int empId;
    private double grossPay;
    private double deduction;
    private double netPay;
    private String disposition;
    
    public PayCheck(LocalDate payPeriodStart, LocalDate payDate) {
        this.payPeriodStart = payPeriodStart;
        this.payDate = payDate;
    }

    
}

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


    private LocalDate payDate;
    private int empId;
    private double grossPay;
    private double deduction;
    private double netPay;
    private String disposition;
    public String getDisposition;
    
    public PayCheck(LocalDate payDate) {
        this.payDate = payDate;
    }

    
}

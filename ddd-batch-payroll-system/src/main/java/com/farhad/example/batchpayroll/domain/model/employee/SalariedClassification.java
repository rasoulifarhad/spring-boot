package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalariedClassification implements PaymentClassification {
    
    private double salary;

    @Override
    public double calculatePay(PayCheck payCheck) {
        return salary;
    }

    @Override
    public void post(LocalDate date) {
        
    }

}

package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalariedClassification implements PaymentClassification {
    
    private double salary;

    @Override
    public double calculatePay(LocalDate date) {
        return salary;
    }

    @Override
    public void post(LocalDate date) {
        
    }

}

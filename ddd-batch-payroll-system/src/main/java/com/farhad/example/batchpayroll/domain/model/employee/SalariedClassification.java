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
        throw new UnsupportedOperationException("Unimplemented method 'calculatePay'");
    }

    @Override
    public void post(LocalDate date) {
        throw new UnsupportedOperationException("Unimplemented method 'post'");
    }

}

package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalariedClassification implements PaymentClassification {
    
    private double salary;

    @Override
    public double calculatePay(Instant date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePay'");
    }

    @Override
    public void post(Instant date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'post'");
    }

}

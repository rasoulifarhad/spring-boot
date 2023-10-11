package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.Date;

import com.farhad.example.batchpayroll.domain.model.Pay;

public class SalariedClassification implements PaymentClassification {
    
    private double salary;

    @Override
    public Pay calculatePay(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePay'");
    }
}

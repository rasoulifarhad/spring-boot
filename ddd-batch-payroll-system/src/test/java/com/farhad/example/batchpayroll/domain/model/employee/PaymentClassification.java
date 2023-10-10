package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.Date;

import com.farhad.example.batchpayroll.domain.model.Pay;

public interface PaymentClassification {

    Pay calculatePay(Date date);
    
}

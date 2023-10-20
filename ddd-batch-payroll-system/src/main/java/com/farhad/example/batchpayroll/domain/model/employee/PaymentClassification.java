package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.Instant;

public interface PaymentClassification {

    double getSalary();
    double calculatePay(Instant date);
}

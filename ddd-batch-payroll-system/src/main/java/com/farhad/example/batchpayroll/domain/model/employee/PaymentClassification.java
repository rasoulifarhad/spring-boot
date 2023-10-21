package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

public interface PaymentClassification {

    double getSalary();
    // the CalculatePay method as calculating the pay from the last posting until the specified date.
    double calculatePay(LocalDate date);
    void post(LocalDate date);
}

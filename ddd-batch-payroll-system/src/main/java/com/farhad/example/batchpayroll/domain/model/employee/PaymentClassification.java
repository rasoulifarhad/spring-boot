package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

public interface PaymentClassification {

    double getSalary();
    // the CalculatePay method as calculating the pay from the last posting until the specified date.
    double calculatePay(PayCheck payCheck);
    void post(LocalDate date);
}

package com.farhad.example.batchpayroll.domain.model.employee;

import lombok.Data;

@Data
public class Employee {
    
    private String employeeId;
    private String name;
    private String address;

    private PaymentClassification paymentClassification;



}

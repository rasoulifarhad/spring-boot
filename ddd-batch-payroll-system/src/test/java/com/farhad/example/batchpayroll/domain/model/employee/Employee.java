package com.farhad.example.batchpayroll.domain.model.employee;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;

import lombok.Data;

@Data
public class Employee {
    
    private String employeeId;
    private String name;
    private String address;

    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;
    private Affiliation affiliation;

}

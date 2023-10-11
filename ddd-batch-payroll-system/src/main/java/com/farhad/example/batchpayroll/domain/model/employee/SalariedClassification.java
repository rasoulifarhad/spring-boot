package com.farhad.example.batchpayroll.domain.model.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SalariedClassification implements PaymentClassification {
    
    private double salary;

}

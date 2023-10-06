package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CommisionedClassification implements PaymentClassification {
    
    private double salary;
    private double commissionRate;
    private List<SalesReceipt> salesReceipts = new ArrayList<>();

}

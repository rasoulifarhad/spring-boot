package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.Date;

import com.farhad.example.batchpayroll.domain.model.Pay;
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
    private PaymentSchedule itsSchedule;

    public Pay pay(Date date) {
        return paymentClassification.calculatePay(date);
    }
     
    public boolean isPayDay(Date date) {
        return false;
    }
}

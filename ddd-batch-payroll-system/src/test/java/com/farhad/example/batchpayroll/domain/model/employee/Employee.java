package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.Date;
import java.util.List;

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
    private List<Affiliation> itsAffiliations;
    private PaymentSchedule itsSchedule;

    public Pay calculatePay(Date date) {
        Pay pay =  paymentClassification.calculatePay(date);
        for (Affiliation affiliation : itsAffiliations) {
            Fee fee = affiliation.getFee(date);
            pay = pay.apply(fee);
        }
        return pay;
    }
     
    public boolean isPayDay(Date date) {
        return false;
    }
}

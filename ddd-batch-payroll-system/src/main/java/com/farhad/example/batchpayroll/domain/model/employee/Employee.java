package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.Date;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.affiliation.NoAffiliation;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;

import lombok.Data;

@Data
public class Employee {
    
    private Integer employeeId;
    private String name;
    private String address;

    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;
    private Affiliation affiliation;
    private PaymentSchedule itsSchedule;

    

    public Employee(Integer employeeId, String name, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.affiliation = new NoAffiliation();
    }

    public double calculatePay(Date date) {
        double pay =  paymentClassification.getSalary();
        Fee fee = affiliation.getFee(date);
        pay = fee.apply(pay);
        return pay;
    }
     
    public boolean isPayDay(Date date) {
        return false;
    }

}

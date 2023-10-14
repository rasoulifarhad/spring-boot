package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;

import lombok.Data;

@Data
public class Employee {
    
    private Integer employeeId;
    private String name;
    private String address;

    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;
    private List<Affiliation> itsAffiliations;
    private PaymentSchedule itsSchedule;

    

    public Employee(Integer employeeId, String name, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.itsAffiliations = new ArrayList<>();
    }

    public double calculatePay(Date date) {
        double pay =  paymentClassification.getSalary();
        for (Affiliation affiliation : itsAffiliations) {
            Fee fee = affiliation.getFee(date);
            pay = fee.apply(pay);
        }
        return pay;
    }
     
    public boolean isPayDay(Date date) {
        return false;
    }

    public void addAffiliation(Affiliation affiliation) {
        itsAffiliations.add(affiliation);
    }
}

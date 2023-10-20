package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.Instant;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;
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

    public double calculatePay(Instant date) {
        double pay =  paymentClassification.getSalary();
        Fee fee = affiliation.getFee(date);
        pay = fee.apply(pay);
        return pay;
    }
     
    public boolean isPayDay(Instant date) {
        return itsSchedule.isPayDay(date);
    }

    public PayCheck payday(Instant date) {
        PayCheck payCheck = new PayCheck(date);
        return payday(payCheck);
    }

    private void post(Instant date) {
        paymentClassification.post(date);
        affiliation.post(date);
    }

    public PayCheck payday(PayCheck payCheck) {
        Instant date = payCheck.getPayDate();
        if(isPayDay(date)) {
            double amount = paymentClassification.calculatePay(date);
            paymentMethod.pay(amount);
            post(date);
            payCheck.setEmpId(employeeId);
            payCheck.setGrossPay(amount);
            payCheck.setDeduction(0.0);
            payCheck.setDisposition("Hold");
            payCheck.setNetPay(amount);
        }
        return payCheck;
    }

}

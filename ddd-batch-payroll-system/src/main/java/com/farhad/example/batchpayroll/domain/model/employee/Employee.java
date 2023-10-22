package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

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

    public double calculatePay(LocalDate date) {
        double pay =  paymentClassification.getSalary();
        return pay;
    }
     
    public boolean isPayDay(LocalDate date) {
        return itsSchedule.isPayDay(date);
    }

    // public PayCheck payday(LocalDate date) {
    //     PayCheck payCheck = new PayCheck(date);
    //     return payday(payCheck);
    // }

    private void post(LocalDate date) {
        paymentClassification.post(date);
        affiliation.post(date);
    }

    public PayCheck payday(PayCheck payCheck) {
        LocalDate date = payCheck.getPayDate();
        if(isPayDay(date)) {
            System.out.println("is pay day");
            double grossPay = paymentClassification.calculatePay(payCheck);
            double deductions = affiliation.calculateDeductions(payCheck);
            double netPay = grossPay - deductions;
            payCheck.setEmpId(employeeId);
            payCheck.setGrossPay(grossPay);
            payCheck.setDeduction(deductions);
            payCheck.setNetPay(netPay);
            paymentMethod.pay(payCheck);
        }
        return payCheck;
    }

    public LocalDate getPayPeriodStartDate(LocalDate payDate) {
        return null;
    }

}

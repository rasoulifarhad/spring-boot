package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

import lombok.Data;

@Data
public class CommisionedClassification implements PaymentClassification {
    
    private double salary;
    private double commissionRate;
    private List<SalesReceipt> salesReceipts = new ArrayList<>();
    
    public CommisionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    
    @Override
    public double getSalary() {
        return salary - (salary * commissionRate);
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.add(salesReceipt);
    }


    @Override
    public double calculatePay(PayCheck payCheck) {
        return salary + calculateCommision(payCheck);

    }

    private double calculateCommision(PayCheck payCheck) {
        return salesReceipts.stream()
                            .filter(salesReceipt -> isInPayPeriod(salesReceipt, payCheck.getPayDate()))
                            .mapToDouble(this::calculatePayForSalesRece)
                            .sum();
    }

    @Override
    public void post(LocalDate date) {
    }

    private double calculatePayForSalesRece(SalesReceipt salesReceipt) {
        return salesReceipt.getAmount() * commissionRate;

    }

    private boolean isInPayPeriod(SalesReceipt salesReceipt, LocalDate payDate) {
        return 
            salesReceipt.getDate().isAfter(payDate.minusWeeks(2)) 
                ? salesReceipt.getDate().isBefore(payDate) || salesReceipt.getDate().isEqual(payDate)
                : false;
    }
    
}

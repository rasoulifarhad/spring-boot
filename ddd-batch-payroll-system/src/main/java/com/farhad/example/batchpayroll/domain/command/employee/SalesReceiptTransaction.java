package com.farhad.example.batchpayroll.domain.command.employee;

import java.time.Instant;

import com.farhad.example.batchpayroll.domain.model.employee.CommisionedClassification;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.SalesReceipt;
import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class SalesReceiptTransaction implements Transaction {

    private Instant date;
    private double amount;
    private int employeeId;

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.inmemory().getEmployee(employeeId);
        if (employee != null) {
            PaymentClassification pc = employee.getPaymentClassification();
            if(pc instanceof CommisionedClassification) {   
                SalesReceipt salesReceipt = new SalesReceipt(date, amount);
                ((CommisionedClassification) pc).addSalesReceipt(salesReceipt);
            } else {
                throw new IllegalStateException("Tried to add SalesReceipt to non-commisioned employee");
            }
        } else {
            throw new IllegalStateException("No such employee.");
        }
    }
    
}

package com.farhad.example.batchpayroll.domain.command.employee;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.employee.HourlyClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.TimeCard;
import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

public class TimeCardTransaction implements Transaction {

    private LocalDate date;
    private double hours;
    private int employeeId;

    
    public TimeCardTransaction(LocalDate date, double hours, int employeeId) {
        this.date = date;
        this.hours = hours;
        this.employeeId = employeeId;
    }


    @Override
    public void execute() {
        Employee employee = PayrollDatabase.INMEMORY.getEmployee(employeeId);
        if(employee != null) {
            PaymentClassification pc = employee.getPaymentClassification();
            if(pc instanceof HourlyClassification) {
                TimeCard timeCard = new TimeCard(date, hours);
                ((HourlyClassification) pc).addTimeCard(timeCard);
            } else {
                throw new IllegalStateException("Tried to add timecard to non-hourly employee");
            }
        } else {
            throw new IllegalStateException("No such employee.");
        }
    }
    
}

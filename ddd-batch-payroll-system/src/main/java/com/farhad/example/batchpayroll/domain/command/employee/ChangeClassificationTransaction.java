package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;

abstract public class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee employee) {
        employee.setPaymentClassification(getPaymentClassification());
        employee.setItsSchedule(getSchedule());
    }

    abstract PaymentSchedule getSchedule();

    abstract PaymentClassification getPaymentClassification();
    
}

package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;
import com.farhad.example.batchpayroll.domain.model.payment.HoldMethod;
import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AddEmployeeTransaction  implements Transaction {

    protected Integer employeeId;
    protected String name;
    protected String address;

    @Override
    public void execute() {
        Employee employee = new Employee(employeeId, name, address);
        employee.setPaymentClassification(getClassification());
        employee.setItsSchedule(getSchedule());
        employee.setPaymentMethod(new HoldMethod());
        PayrollDatabase.inmemory().addEmployee(employeeId, employee);
    }

    protected abstract PaymentSchedule getSchedule();

    protected abstract PaymentClassification getClassification();

    


}

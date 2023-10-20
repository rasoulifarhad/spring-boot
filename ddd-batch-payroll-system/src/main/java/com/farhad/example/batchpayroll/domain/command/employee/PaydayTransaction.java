package com.farhad.example.batchpayroll.domain.command.employee;

import java.time.Instant;
import java.util.List;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaydayTransaction implements Transaction {

    protected Instant date;

    @Override
    public void execute() {
        List<Employee> employees = PayrollDatabase.inmemory().getEmployees();
        for (Employee employee : employees) {
            employee.payday(date);
        }
    }
    
}

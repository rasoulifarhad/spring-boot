package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

import lombok.Getter;

@Getter
public abstract class ChangeEmployeeTransaction implements Transaction {
    
    protected int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee employee = PayrollDatabase.inmemory().getEmployee(Integer.valueOf(empId));
        if (employee != null) {
            change(employee);
        }
    }

    protected abstract void change(Employee employee);

    
}

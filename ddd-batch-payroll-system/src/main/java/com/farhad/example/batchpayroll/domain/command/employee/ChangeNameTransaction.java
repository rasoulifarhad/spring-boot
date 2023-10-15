package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private String name;

    public ChangeNameTransaction(int empId, String name) {
        super(empId);
        this.name = name;
    }

    @Override
    protected void change(Employee employee) {
        employee.setName(name);
    }
    
}

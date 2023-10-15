package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {

    private String address;
    
    public ChangeAddressTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    protected void change(Employee employee) {
        employee.setAddress(address);
    }
    
}

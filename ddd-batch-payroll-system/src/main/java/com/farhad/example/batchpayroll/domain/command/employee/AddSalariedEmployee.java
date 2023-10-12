package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double salary;

    public AddSalariedEmployee(Integer employeeId, String name, String address, double salary) {
        super(employeeId, name, address);
        this.salary = salary;
    }

    @Override
    protected PaymentSchedule getSchedule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSchedule'");
    }

    @Override
    protected PaymentClassification getClassification() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassification'");
    }

    
}

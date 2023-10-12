package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction{

    private double salary;
    private double commissionRate;


    public AddCommissionedEmployee(
                    Integer employeeId,    
                    String name, 
                    String address,
                    double salary,
                    double commissionRate) {
        super(employeeId, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
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

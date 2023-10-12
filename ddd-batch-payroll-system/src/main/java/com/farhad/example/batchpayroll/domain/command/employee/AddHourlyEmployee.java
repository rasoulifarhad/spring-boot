package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction{

    private double hourlyRate;


    public AddHourlyEmployee(
                    Integer employeeId, 
                    String name, 
                    String address, 
                    double hourlyRate) {
        super(employeeId, name, address);
        this.hourlyRate = hourlyRate;
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

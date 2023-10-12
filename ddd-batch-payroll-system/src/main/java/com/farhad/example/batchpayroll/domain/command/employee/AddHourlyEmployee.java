package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.HourlyClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;
import com.farhad.example.batchpayroll.domain.model.employee.WeeklySchedule;

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
    protected PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new HourlyClassification();
    }
    
}

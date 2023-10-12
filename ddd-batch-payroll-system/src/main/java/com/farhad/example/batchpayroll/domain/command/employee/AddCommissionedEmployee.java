package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.BiweeklySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.CommisionedClassification;
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
    protected PaymentSchedule getSchedule() {
        return  new BiweeklySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommisionedClassification();
    }
    
    
}

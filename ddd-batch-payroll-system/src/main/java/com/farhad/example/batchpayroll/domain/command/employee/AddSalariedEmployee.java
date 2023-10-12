package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.MonthlySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;
import com.farhad.example.batchpayroll.domain.model.employee.SalariedClassification;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double salary;

    public AddSalariedEmployee(Integer employeeId, String name, String address, double salary) {
        super(employeeId, name, address);
        this.salary = salary;
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    
}

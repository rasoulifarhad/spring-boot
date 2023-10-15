package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.MonthlySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;
import com.farhad.example.batchpayroll.domain.model.employee.SalariedClassification;

public class ChangeSalariedTransaction  extends ChangeClassificationTransaction {

    private double salary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    PaymentClassification getPaymentClassification() {
        return new SalariedClassification(salary);
    }
    
}

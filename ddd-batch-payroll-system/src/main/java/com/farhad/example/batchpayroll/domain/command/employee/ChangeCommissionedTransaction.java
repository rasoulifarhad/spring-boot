package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.BiweeklySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.CommisionedClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;

public class ChangeCommissionedTransaction  extends ChangeClassificationTransaction {

    private double salary;
    private double commissionRate;

    
    public ChangeCommissionedTransaction(int empId, double salary, double commissionRate) {
        super(empId);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public ChangeCommissionedTransaction(int empId) {
        super(empId);
    }

    protected PaymentSchedule getSchedule() {
        return  new BiweeklySchedule();
    }

    @Override
    protected PaymentClassification getPaymentClassification() {
        return new CommisionedClassification(salary, commissionRate);
    }


    
}

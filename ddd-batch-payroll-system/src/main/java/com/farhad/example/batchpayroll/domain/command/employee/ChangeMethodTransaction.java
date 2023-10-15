package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee employee) {
        employee.setPaymentMethod(getMethod());
    }

    abstract PaymentMethod getMethod();
    
}

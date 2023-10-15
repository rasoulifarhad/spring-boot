package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.payment.DirectMethod;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction {

    public ChangeDirectTransaction(int empId) {
        super(empId);
    }

    @Override
    PaymentMethod getMethod() {
        return new DirectMethod();
    }
    
}

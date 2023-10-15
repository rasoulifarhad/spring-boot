package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.payment.HoldMethod;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

    public ChangeHoldTransaction(int empId) {
        super(empId);
    }

    @Override
    PaymentMethod getMethod() {
        return new HoldMethod();
    }
    
}

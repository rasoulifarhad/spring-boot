package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.payment.MailMethod;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction{

    public ChangeMailTransaction(int empId) {
        super(empId);
    }

    @Override
    PaymentMethod getMethod() {
        return new MailMethod();
    }
    
}

package com.farhad.example.batchpayroll.domain.model.payment;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

public interface PaymentMethod {

    void pay(PayCheck payCheck);
    
}

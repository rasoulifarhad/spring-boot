package com.farhad.example.batchpayroll.domain.model.payment;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

public class MailMethod implements PaymentMethod{

    @Override
    public void pay(PayCheck payCheck) {
    }
}

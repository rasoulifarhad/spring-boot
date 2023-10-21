package com.farhad.example.batchpayroll.domain.model.payment;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;
import com.farhad.example.batchpayroll.domain.model.account.Account;
import com.farhad.example.batchpayroll.domain.model.account.Bank;

public class DirectMethod implements PaymentMethod{
    
    private Bank bank;
    private Account account    ;
    @Override
    public void pay(PayCheck payCheck) {
    }

}

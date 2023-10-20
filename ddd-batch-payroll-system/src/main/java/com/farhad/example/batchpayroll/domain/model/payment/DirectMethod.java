package com.farhad.example.batchpayroll.domain.model.payment;

import com.farhad.example.batchpayroll.domain.model.account.Account;
import com.farhad.example.batchpayroll.domain.model.account.Bank;

public class DirectMethod implements PaymentMethod{
    
    private Bank bank;
    private Account account    ;
    @Override
    public void pay(double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pay'");
    }

}

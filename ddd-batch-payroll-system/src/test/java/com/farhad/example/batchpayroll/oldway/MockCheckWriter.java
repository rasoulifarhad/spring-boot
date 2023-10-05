package com.farhad.example.batchpayroll.oldway;

import java.util.function.BooleanSupplier;

public class MockCheckWriter implements CheckWriter{

    @Override
    public void writeCheck(Amount employeePay) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeCheck'");
    }

    public BooleanSupplier checksWereWritenCorrectly() {
        return null;
    }

    public BooleanSupplier paymentsWerePostedCorrectly() {
        return null;
    }
    
}

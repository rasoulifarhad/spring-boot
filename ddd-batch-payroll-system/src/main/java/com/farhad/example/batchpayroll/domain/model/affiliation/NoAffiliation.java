package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

public class NoAffiliation implements Affiliation{

    @Override
    public void post(LocalDate date) {
    }

    @Override
    public double calculateDeductions(PayCheck payCheck) {
        return 0.0;
    }
    
}

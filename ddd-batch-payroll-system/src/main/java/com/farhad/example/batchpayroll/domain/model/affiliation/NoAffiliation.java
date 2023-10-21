package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public class NoAffiliation implements Affiliation{

    @Override
    public Fee getFee(LocalDate date) {
        throw new UnsupportedOperationException("Unimplemented method 'getFee'");
    }

    @Override
    public void post(LocalDate date) {
        throw new UnsupportedOperationException("Unimplemented method 'post'");
    }
    
}

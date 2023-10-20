package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.Instant;

import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public class NoAffiliation implements Affiliation{

    @Override
    public Fee getFee(Instant date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFee'");
    }
    
}

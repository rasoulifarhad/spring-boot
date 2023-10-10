package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.util.Date;

import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public class NoAffiliation implements Affiliation{

    @Override
    public Fee getFee(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFee'");
    }
    
}

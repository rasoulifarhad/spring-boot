package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.util.Date;

import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public interface Affiliation {

    Fee getFee(Date date);
    
}

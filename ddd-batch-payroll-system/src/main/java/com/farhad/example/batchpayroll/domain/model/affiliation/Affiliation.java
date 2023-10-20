package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.Instant;

import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public interface Affiliation {

    Fee getFee(Instant date);

    void post(Instant date);
    
}

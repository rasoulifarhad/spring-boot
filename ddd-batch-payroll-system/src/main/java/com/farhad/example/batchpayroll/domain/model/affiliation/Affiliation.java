package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.model.employee.Fee;

public interface Affiliation {

    Fee getFee(LocalDate date);

    void post(LocalDate date);
    
}

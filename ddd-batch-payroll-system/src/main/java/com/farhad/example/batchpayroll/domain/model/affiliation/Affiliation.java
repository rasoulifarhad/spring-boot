package com.farhad.example.batchpayroll.domain.model.affiliation;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;

public interface Affiliation {

    double calculateDeductions(PayCheck payCheck);

    void post(LocalDate date);
    
}

package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.affiliation.NoAffiliation;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    Affiliation getAffiliation() {
        return new NoAffiliation();
    }
    
}

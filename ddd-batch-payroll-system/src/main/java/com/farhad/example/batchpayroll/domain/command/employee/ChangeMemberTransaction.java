package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.affiliation.UnionAffiliation;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private double dues;

    public ChangeMemberTransaction(int empId, double dues) {
        super(empId);
        this.dues = dues;
    }

    @Override
    Affiliation getAffiliation() {
        return new UnionAffiliation(dues);
    }
    
}

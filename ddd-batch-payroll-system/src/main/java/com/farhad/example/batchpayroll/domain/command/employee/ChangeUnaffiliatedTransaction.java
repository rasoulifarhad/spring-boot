package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.affiliation.NoAffiliation;
import com.farhad.example.batchpayroll.domain.model.affiliation.UnionAffiliation;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    void recordMemberShip(Employee employee) {
        if(employee.getAffiliation() instanceof UnionAffiliation) {
            UnionAffiliation uf = (UnionAffiliation)employee.getAffiliation();
            PayrollDatabase.inmemory().removeUnionMember(uf.getMemberId());
        }

    }
    
}

package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.affiliation.UnionAffiliation;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private int memberId;
    private double dues;


    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    @Override
    void recordMemberShip(Employee employee) {
        PayrollDatabase.inmemory().addUnionMember(memberId, employee);
    }
    
}

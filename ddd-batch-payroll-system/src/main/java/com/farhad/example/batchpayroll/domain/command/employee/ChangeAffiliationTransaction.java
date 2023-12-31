package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee employee) {
        recordMemberShip(employee);
        employee.setAffiliation(getAffiliation());
    }

    abstract void recordMemberShip(Employee employee);
    abstract Affiliation getAffiliation();
}

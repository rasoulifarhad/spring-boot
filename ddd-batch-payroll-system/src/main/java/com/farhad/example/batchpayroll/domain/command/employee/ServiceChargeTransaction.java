package com.farhad.example.batchpayroll.domain.command.employee;

import java.time.LocalDate;

import com.farhad.example.batchpayroll.domain.model.ServiceCharge;
import com.farhad.example.batchpayroll.domain.model.affiliation.Affiliation;
import com.farhad.example.batchpayroll.domain.model.affiliation.UnionAffiliation;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ServiceChargeTransaction implements Transaction {

    private int memberId;
    private LocalDate date;
    private double charge;
    
    @Override
    public void execute() {

        Employee employee = PayrollDatabase.inmemory().getEmployeeByMemberId(memberId);
        if(employee != null) {
            Affiliation affiliation = employee.getAffiliation();
            if(affiliation instanceof UnionAffiliation ){
                ServiceCharge serviceCharge = new ServiceCharge(date, charge);
                ((UnionAffiliation) affiliation).addServiceCharge(serviceCharge);
            } else {
                throw new IllegalStateException("Tried to add serviceCharge to non-Union affiliation ");
            }
        } else {
            throw new IllegalStateException("No such employee.");
        }
    }
    
}

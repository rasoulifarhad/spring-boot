package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DeleteEmployee implements Transaction {

    
    private final Integer employeeId;


    @Override
    public void execute() {
        PayrollDatabase.inmemory().deleteEmployee(employeeId);
    }
    
}

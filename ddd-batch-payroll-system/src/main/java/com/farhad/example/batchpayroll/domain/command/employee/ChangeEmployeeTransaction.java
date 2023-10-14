package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;

import lombok.Getter;

@Getter
public abstract class ChangeEmployeeTransaction implements Transaction {
    
    protected int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    
}

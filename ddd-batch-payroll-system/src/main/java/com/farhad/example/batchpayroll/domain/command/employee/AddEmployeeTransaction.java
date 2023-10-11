package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AddEmployeeTransaction  implements Transaction {

    protected Integer employeeId;
    protected String name;
    protected String address;

    


}

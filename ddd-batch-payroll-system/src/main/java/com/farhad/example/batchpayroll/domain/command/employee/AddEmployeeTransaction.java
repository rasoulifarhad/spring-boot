package com.farhad.example.batchpayroll.domain.command.employee;

import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;

public abstract class AddEmployeeTransaction  implements Transaction {

    protected String name;
    protected String employeeId;
    protected String address;
}

package com.farhad.example.batchpayroll.infrastructure.persistence;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.infrastructure.persistence.memory.InMemoryPayrollDatabase;

public interface PayrollDatabase {

    static final PayrollDatabase INMEMORY = new InMemoryPayrollDatabase();

    Employee getEmployee(int empId);
    void addEmployee(int id, Employee employee);
    void clear();
    
    public static PayrollDatabase inmemory() {
        return INMEMORY;
    }
}

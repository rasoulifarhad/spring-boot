package com.farhad.example.batchpayroll.infrastructure.persistence;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.infrastructure.persistence.memory.InMemoryPayrollDatabase;

public interface PayrollDatabase {

    Employee getEmployee(int empId);
    void addEmployee(int id, Employee employee);
    void clear();
    
    public static PayrollDatabase inmemory() {
        return new InMemoryPayrollDatabase();
    }
}

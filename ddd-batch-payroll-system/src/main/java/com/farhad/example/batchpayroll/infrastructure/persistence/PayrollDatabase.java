package com.farhad.example.batchpayroll.infrastructure.persistence;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;

public interface PayrollDatabase {

    Employee getEmployee(int empId);
    void addEmployee(int id, Employee employee);
    void clear();
    
}

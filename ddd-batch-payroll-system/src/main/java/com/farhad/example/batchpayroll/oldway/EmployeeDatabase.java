package com.farhad.example.batchpayroll.oldway;

public interface EmployeeDatabase {

    void putEmployee(Employee employee);
    Employee getEmployee(EmployeeId id);
    
}

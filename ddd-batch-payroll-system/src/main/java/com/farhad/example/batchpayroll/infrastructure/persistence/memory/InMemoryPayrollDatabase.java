package com.farhad.example.batchpayroll.infrastructure.persistence.memory;

import java.util.HashMap;
import java.util.Map;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

public class InMemoryPayrollDatabase implements PayrollDatabase {

    private Map<Integer, Employee> employees = new HashMap<>();

    private Map<Integer, Integer> membersIdtoEmployeeIdMap = new HashMap<>();
    
    @Override
    public Employee getEmployee(int id) {
        return employees.get(Integer.valueOf(id));
    }

    @Override
    public void addEmployee(int id, Employee employee) {
        employees.put(Integer.valueOf(id), employee);
    }

    @Override
    public void clear() {
        employees.clear();
    }
    
}

package com.farhad.example.batchpayroll.infrastructure.persistence;

import java.util.HashMap;
import java.util.Map;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;

public interface PayrollDatabase {

    static final PayrollDatabase INMEMORY = new InMemoryPayrollDatabase();

    Employee getEmployee(int employeeId);
    void addEmployee(int employeeId, Employee employee);
    void deleteEmployee(int employeeId);
    void clear();
    
    public static PayrollDatabase inmemory() {
        return INMEMORY;
    }

    class InMemoryPayrollDatabase implements PayrollDatabase {

        
        private InMemoryPayrollDatabase() {
        }

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

        @Override
        public void deleteEmployee(int employeeId) {
            employees.remove(employeeId);
        }
        
    }    
}



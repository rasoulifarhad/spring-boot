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
    void addUnionMember(int memberId, Employee employee);    
    void removeUnionMember(int memberId
    );    
    Employee getEmployeeByMemberId(int memberId);
    
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

        @Override
        public void addUnionMember(int memberId, Employee employee) {
            membersIdtoEmployeeIdMap.put(Integer.valueOf(memberId), employee.getEmployeeId());
        }

        @Override
        public Employee getEmployeeByMemberId(int memberId) {
            Integer employeeId = membersIdtoEmployeeIdMap.get(Integer.valueOf(memberId));
            return employeeId == null ? null : employees.get(employeeId);
        }

        @Override
        public void removeUnionMember(int memberId) {
            membersIdtoEmployeeIdMap.remove(Integer.valueOf(memberId));
        }
        

    }

}



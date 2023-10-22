package com.farhad.example.batchpayroll.domain.command.employee;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.transaction.Transaction;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaydayTransaction implements Transaction {

    protected final LocalDate payDate;
    private Map<Integer, PayCheck> payChecks = new HashMap<>();
    
    @Override
    public void execute() {
        List<Employee> employees = PayrollDatabase.inmemory().getEmployees();
        for (Employee employee : employees) {
            if(employee.isPayDay(payDate)) {
                PayCheck payCheck = new PayCheck(employee.getPayPeriodStartDate(payDate), payDate);
                payChecks.put(employee.getEmployeeId(), payCheck);
                employee.payday(payCheck);

                // PayCheck payCheck = employee.payday(date);
            }
           
        }
    }

    public PayCheck getPayCheck(int empId) {
        return payChecks.get(Integer.valueOf(empId));
    }
    
}

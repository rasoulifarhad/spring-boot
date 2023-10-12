package com.farhad.example.batchpayroll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.farhad.example.batchpayroll.domain.command.employee.AddSalariedEmployee;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.employee.MonthlySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;
import com.farhad.example.batchpayroll.domain.model.employee.SalariedClassification;
import com.farhad.example.batchpayroll.domain.model.payment.HoldMethod;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

public class PayrollTest {
    
    @Test
    public void AddSalariedEmployeeTest() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "name #1", "address #1", 1000.00);
        t.execute();
        Employee employee =PayrollDatabase.inmemory().getEmployee(empId);
        assertEquals("name #1", employee.getName());

        PaymentClassification paymentClassification = employee.getPaymentClassification();
        assertTrue(paymentClassification instanceof SalariedClassification);

        assertEquals(1000.00, paymentClassification.getSalary(), 0.001);
        PaymentSchedule paymentSchedule = employee.getItsSchedule();
        assertTrue(paymentSchedule instanceof MonthlySchedule);

        PaymentMethod paymentMethod = employee.getPaymentMethod();
        assertTrue(paymentMethod instanceof HoldMethod);
    }
}

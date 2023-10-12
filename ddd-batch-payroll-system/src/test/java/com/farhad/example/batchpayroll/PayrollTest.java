package com.farhad.example.batchpayroll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.batchpayroll.domain.command.employee.AddCommissionedEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.AddHourlyEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.AddSalariedEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.DeleteEmployee;
import com.farhad.example.batchpayroll.domain.model.employee.BiweeklySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.CommisionedClassification;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.employee.HourlyClassification;
import com.farhad.example.batchpayroll.domain.model.employee.MonthlySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;
import com.farhad.example.batchpayroll.domain.model.employee.SalariedClassification;
import com.farhad.example.batchpayroll.domain.model.employee.WeeklySchedule;
import com.farhad.example.batchpayroll.domain.model.payment.HoldMethod;
import com.farhad.example.batchpayroll.domain.model.payment.PaymentMethod;
import com.farhad.example.batchpayroll.infrastructure.persistence.PayrollDatabase;

public class PayrollTest {
    PayrollDatabase payrollDatabase ;

    @BeforeEach
    public void setup() {
        payrollDatabase = PayrollDatabase.inmemory();
    }

    @Test
    public void AddSalariedEmployeeTest() {
        int empId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empId, "name #1", "address #1", 1000.00);
        t.execute();
        Employee employee = payrollDatabase.getEmployee(empId);
        assertEquals("name #1", employee.getName());

        PaymentClassification paymentClassification = employee.getPaymentClassification();
        assertTrue(paymentClassification instanceof SalariedClassification);

        assertEquals(1000.00, paymentClassification.getSalary(), 0.001);
        PaymentSchedule paymentSchedule = employee.getItsSchedule();
        assertTrue(paymentSchedule instanceof MonthlySchedule);

        PaymentMethod paymentMethod = employee.getPaymentMethod();
        assertTrue(paymentMethod instanceof HoldMethod);
    }

    @Test
    public void AddHourlyEmployeeTest() {
        int empId = 1;
        double hourlyRate = 34.00;
        AddHourlyEmployee t = new AddHourlyEmployee(
                            empId, 
                            
                            "name #1", 
                            "address #1", 
                            hourlyRate);
        t.execute();
        Employee employee = payrollDatabase.getEmployee(empId);
        assertEquals("name #1", employee.getName());

        PaymentClassification paymentClassification = employee.getPaymentClassification();
        assertTrue(paymentClassification instanceof HourlyClassification);

        assertEquals(1000.00, paymentClassification.getSalary(), 0.001);
        PaymentSchedule paymentSchedule = employee.getItsSchedule();
        assertTrue(paymentSchedule instanceof WeeklySchedule);

        PaymentMethod paymentMethod = employee.getPaymentMethod();
        assertTrue(paymentMethod instanceof HoldMethod);
    }

        @Test
    public void AddCommissionedEmployeeTest() {
        int empId = 1;
        double salary = 1000.00;
        double commissionRate = 0.01;
        AddCommissionedEmployee t = new AddCommissionedEmployee(
                            empId, 
                            "name #1", 
                            "address #1", 
                            salary,
                            commissionRate);
        t.execute();
        Employee employee = payrollDatabase.getEmployee(empId);
        assertEquals("name #1", employee.getName());

        PaymentClassification paymentClassification = employee.getPaymentClassification();
        assertTrue(paymentClassification instanceof CommisionedClassification);

        assertEquals(990.00, paymentClassification.getSalary(), 0.001);
        PaymentSchedule paymentSchedule = employee.getItsSchedule();
        assertTrue(paymentSchedule instanceof BiweeklySchedule);

        PaymentMethod paymentMethod = employee.getPaymentMethod();
        assertTrue(paymentMethod instanceof HoldMethod);
    }

    @Test
    public void deleteEmployeeTest() {
        int empId = 3;
        AddCommissionedEmployee t = new AddCommissionedEmployee(
            empId, 
            "name #" + empId, 
            "address #" + empId , 
            2500, 
            0.032);
        t.execute();

        assertNotNull(payrollDatabase.getEmployee(empId));
        assertEquals(empId, payrollDatabase.getEmployee(empId).getEmployeeId());

        DeleteEmployee dt = new DeleteEmployee(empId);
        dt.execute();

        assertNull(payrollDatabase.getEmployee(empId));
    }

}

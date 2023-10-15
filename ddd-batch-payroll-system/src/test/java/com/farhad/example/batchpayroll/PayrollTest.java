package com.farhad.example.batchpayroll;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.farhad.example.batchpayroll.domain.command.employee.AddCommissionedEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.AddHourlyEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.AddSalariedEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeAddressTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeNameTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.DeleteEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.ServiceChargeTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.TimeCardTransaction;
import com.farhad.example.batchpayroll.domain.model.ServiceCharge;
import com.farhad.example.batchpayroll.domain.model.affiliation.UnionAffiliation;
import com.farhad.example.batchpayroll.domain.model.employee.BiweeklySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.CommisionedClassification;
import com.farhad.example.batchpayroll.domain.model.employee.Employee;
import com.farhad.example.batchpayroll.domain.model.employee.HourlyClassification;
import com.farhad.example.batchpayroll.domain.model.employee.MonthlySchedule;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentClassification;
import com.farhad.example.batchpayroll.domain.model.employee.PaymentSchedule;
import com.farhad.example.batchpayroll.domain.model.employee.SalariedClassification;
import com.farhad.example.batchpayroll.domain.model.employee.TimeCard;
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

    @Test
    public void timeCardTransactionTest() {
        int empId = 2;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(
                    empId, 
                    "name #" + empId, "address #" + empId, 12.25);
        hourlyEmployee.execute();

        TimeCardTransaction timeCardTransaction = 
                new TimeCardTransaction(LocalDate.now(), 8.0 , empId);
        timeCardTransaction.execute();

        Employee employee = payrollDatabase.getEmployee(empId);
        assertNotNull(employee);
        PaymentClassification pc = employee.getPaymentClassification();
        assertTrue(pc instanceof HourlyClassification);

        HourlyClassification hc = (HourlyClassification) pc;
        TimeCard tc = hc.getTimeCard(LocalDate.now());
        assertNotNull(tc);
        assertThat(Double.valueOf(tc.getHours())).isEqualTo(Double.valueOf(8.0));
    }

    @Test
    public void addServiceChargeTest() {
        int empId = 2;
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(
                    empId, 
                    "name #" + empId, "address #" + empId, 12.25);
        hourlyEmployee.execute();
        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        UnionAffiliation unionAffiliation = new UnionAffiliation(12.25);
        employee.setAffiliation(unionAffiliation);
        int memberId = 86;
        PayrollDatabase.inmemory().addUnionMember(memberId, employee);
        ServiceChargeTransaction serviceChargeTransaction = new ServiceChargeTransaction(memberId, LocalDate.now(), 12.25);
        serviceChargeTransaction.execute();
        ServiceCharge serviceCharge = unionAffiliation.getServiceCharge(LocalDate.now());
        assertNotNull(serviceCharge);
        assertThat(12.25).isEqualTo(serviceCharge.getCharge());
    }

    @Test
    public void changeNameTransactionTest() {
        int empId = 2;
        anHourlyEmployee(empId, 12.25).execute();
        ChangeNameTransaction cnt = new ChangeNameTransaction(empId, "changed name #" + empId);
        cnt.execute();
        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        final String expectedName = "changed name #" + empId;
        assertThat(employee.getName()).isEqualTo(expectedName);
        
    }

    @Test
    public void changeAddressTransactionTest() {
        int empId = 2;
        anHourlyEmployee(empId, 12.25).execute();
        ChangeAddressTransaction cat = new ChangeAddressTransaction(empId, "changed address #" + empId);
        cat.execute();
        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        final String expectedAddress = "changed address #" + empId;
        assertThat(employee.getAddress()).isEqualTo(expectedAddress);
        
    }

    private static AddHourlyEmployee anHourlyEmployee(int empId, double hourlyRate) {
        return new AddHourlyEmployee(
            empId, 
            "name #" + empId, 
            "address #" + empId, 
            hourlyRate);
    }
}

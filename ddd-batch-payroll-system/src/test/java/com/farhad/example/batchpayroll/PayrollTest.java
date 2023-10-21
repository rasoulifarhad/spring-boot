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
import com.farhad.example.batchpayroll.domain.command.employee.ChangeCommissionedTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeDirectTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeHourlyTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeMailTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeMemberTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeNameTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.ChangeSalariedTransaction;
import com.farhad.example.batchpayroll.domain.command.employee.DeleteEmployee;
import com.farhad.example.batchpayroll.domain.command.employee.PayCheck;
import com.farhad.example.batchpayroll.domain.command.employee.PaydayTransaction;
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
import com.farhad.example.batchpayroll.domain.model.payment.DirectMethod;
import com.farhad.example.batchpayroll.domain.model.payment.HoldMethod;
import com.farhad.example.batchpayroll.domain.model.payment.MailMethod;
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
        int memberId = 86;
        UnionAffiliation unionAffiliation = new UnionAffiliation(memberId, 12.25);
        employee.setAffiliation(unionAffiliation);
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
        anHourlyEmp(empId, 12.25).execute();
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
        anHourlyEmp(empId, 12.25).execute();
        ChangeAddressTransaction cat = new ChangeAddressTransaction(empId, "changed address #" + empId);
        cat.execute();
        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        final String expectedAddress = "changed address #" + empId;
        assertThat(employee.getAddress()).isEqualTo(expectedAddress);
        
    }

    @Test
    public void changeHourlyTransactionTest() {
        int empId = 3;
        AddCommissionedEmployee t = aCommissionedEmp(empId, 2500, 3.2);
        t.execute();

        ChangeHourlyTransaction cht = new ChangeHourlyTransaction(empId, 27.52);
        cht.execute();

        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        assertNotNull(employee.getPaymentClassification());
        assertTrue(employee.getPaymentClassification() instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification)employee.getPaymentClassification();
        assertThat(hc.getHourlyRate()).isEqualTo(27.52);
        assertTrue(employee.getItsSchedule() instanceof WeeklySchedule);
    }

    @Test
    public void changeSalariedTransactionTest() {
        int empId = 4;
        AddCommissionedEmployee t = aCommissionedEmp(empId, 2500, 3.2);
        t.execute();

        ChangeSalariedTransaction cst = new ChangeSalariedTransaction(empId, 1000.0);
        cst.execute();

        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        assertNotNull(employee.getPaymentClassification());
        assertTrue(employee.getPaymentClassification() instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification)employee.getPaymentClassification();
        assertThat(sc.getSalary()).isEqualTo(1000.0);
        assertTrue(employee.getItsSchedule() instanceof MonthlySchedule);
    }

    @Test
    public void changeCommissionedTransactionTest() {
        int empId = 5;
        AddSalariedEmployee t = aSalariedEmp(empId, 1000.0);
        t.execute();

        ChangeCommissionedTransaction cst = new ChangeCommissionedTransaction(empId,1000.0, 3.2);
        cst.execute();

        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        assertNotNull(employee.getPaymentClassification());
        assertTrue(employee.getPaymentClassification() instanceof CommisionedClassification);
        CommisionedClassification cc = (CommisionedClassification)employee.getPaymentClassification();
        // assertThat(cc.getSalary()).isEqualTo(1000.0);
        assertThat(cc.getCommissionRate()).isEqualTo(3.2);
        assertTrue(employee.getItsSchedule() instanceof BiweeklySchedule);
    }

    @Test
    public void changeDirectTransactionTest() {
        int empId = 2;
        AddSalariedEmployee t = aSalariedEmp(empId, 1000.0);
        t.execute();
        
        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        assertTrue(employee.getPaymentMethod() instanceof HoldMethod );
        
        ChangeDirectTransaction cdt = new ChangeDirectTransaction(empId);
        cdt.execute();
        assertTrue(employee.getPaymentMethod() instanceof DirectMethod );
    }

    @Test
    public void changeMailTransactionTest() {
        int empId = 2;
        AddSalariedEmployee t = aSalariedEmp(empId, 1000.0);
        t.execute();
        
        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        assertTrue(employee.getPaymentMethod() instanceof HoldMethod );
        
        ChangeMailTransaction cmt = new ChangeMailTransaction(empId);
        cmt.execute();
        assertTrue(employee.getPaymentMethod() instanceof MailMethod );
    }
    
   
   @Test
    public void changeMemberTransactionTest() {
        int empId = 2;
        int memberId = 7734;
        AddHourlyEmployee t = anHourlyEmp(empId, 12.25);
        t.execute();
              
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId,99.42);
        cmt.execute();
        Employee employee = PayrollDatabase.inmemory().getEmployee(empId);
        assertNotNull(employee);
        assertNotNull(employee.getAffiliation());
         
        assertTrue(employee.getAffiliation() instanceof UnionAffiliation );
        UnionAffiliation uf = (UnionAffiliation) employee.getAffiliation();
        assertEquals( 99.42, uf.getDues(), 0.001);
        Employee member = PayrollDatabase.inmemory().getEmployeeByMemberId(memberId);
        assertNotNull(member);
        assertThat(employee).isEqualTo(member);
    }
        
    @Test
    void paySingleSalariedEmployeeTest() {
        int empId = 2;
        AddSalariedEmployee t = aSalariedEmp(empId, 1000.00);
        t.execute();
        LocalDate date = LocalDate.of(2001, 11, 30);

        PaydayTransaction pdt = new PaydayTransaction(date);
        pdt.execute();
        PayCheck payCheck = pdt.getPayCheck(empId);
        assertNotNull(payCheck);
        assertThat(payCheck.getPayDate()).isEqualTo(date);
        assertEquals(1000.00, payCheck.getGrossPay(), 0.001);
        assertThat(payCheck.getDisposition).isEqualTo("Hold");
        assertEquals(0.0, payCheck.getDeduction(), 0.001);
        assertEquals(1000.00, payCheck.getNetPay(), 0.001);
    }

    @Test
    void paySingleSalariedEmployeeOnWrongDateTest() {
        int empId = 2;
        AddSalariedEmployee t = aSalariedEmp(empId, 1000.00);
        t.execute();
        LocalDate date = LocalDate.of(2001, 11, 29);

        PaydayTransaction pdt = new PaydayTransaction(date);
        pdt.execute();
        PayCheck payCheck = pdt.getPayCheck(empId);
        assertNull(payCheck);
    }
    

    private static AddHourlyEmployee anHourlyEmp(int empId, double hourlyRate) {
        return new AddHourlyEmployee(
            empId, 
            "name #" + empId, 
            "address #" + empId, 
            hourlyRate);
    }

    private static AddCommissionedEmployee aCommissionedEmp(int empId,double salary, double commissionRate) {
        return new AddCommissionedEmployee(
            empId, 
            "name #" + empId, 
            "address #" + empId, 
            salary, 
            commissionRate);
    }

    private static AddSalariedEmployee aSalariedEmp(int empId,double salary) {
        return new AddSalariedEmployee(
            empId, 
            "name #" + empId, 
            "address #" + empId, 
            salary);
    }
}

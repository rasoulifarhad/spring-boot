package com.farhad.example.batchpayroll.oldway;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PayrollTest {


    @Test
    public void testPayroll() {
        MockCheckWriter checkWriter = new MockCheckWriter();
        MockEmployeeDatabase employeeDatabase = new MockEmployeeDatabase();
        Payroll payroll =  new Payroll(employeeDatabase, checkWriter);
        payroll.payEmployees();
        assertTrue(checkWriter.checksWereWritenCorrectly());
        assertTrue(checkWriter.paymentsWerePostedCorrectly());
    }
}

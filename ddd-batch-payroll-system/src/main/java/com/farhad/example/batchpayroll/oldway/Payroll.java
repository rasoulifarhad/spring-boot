package com.farhad.example.batchpayroll.oldway;

public class Payroll {
    
    private EmployeeDatabase employeeDatabase;
    private CheckWriter checkWriter;

    public Payroll(EmployeeDatabase employeeDatabase, CheckWriter checkWriter) {
        this.employeeDatabase = employeeDatabase;
        this.checkWriter = checkWriter;
    }

    public void postPaymentFor(EmployeeId employeeId) {

        Employee employee = employeeDatabase.getEmployee(employeeId);
        Amount employeePay = employee.calculatePay();
        checkWriter.writeCheck(employeePay);
        employee.postPayment();
        employeeDatabase.putEmployee(employee);

    }

    public void payEmployees() {
    }

    public void payDay() {

    }

    public void AddEmployee(Employee employee) {

    }
}

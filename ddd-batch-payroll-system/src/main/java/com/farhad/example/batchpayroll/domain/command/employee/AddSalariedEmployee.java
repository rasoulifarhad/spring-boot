package com.farhad.example.batchpayroll.domain.command.employee;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double salary;

    public AddSalariedEmployee(Integer employeeId, String name, String address, double salary) {
        super(employeeId, name, address);
        this.salary = salary;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}

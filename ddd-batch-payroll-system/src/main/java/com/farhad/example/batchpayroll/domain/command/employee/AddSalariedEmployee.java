package com.farhad.example.batchpayroll.domain.command.employee;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    
    public AddSalariedEmployee(Integer employeeId, String name, String address) {
        super(employeeId, name, address);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}

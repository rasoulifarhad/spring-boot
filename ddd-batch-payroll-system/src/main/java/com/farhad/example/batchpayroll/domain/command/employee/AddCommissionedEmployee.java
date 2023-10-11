package com.farhad.example.batchpayroll.domain.command.employee;

public class AddCommissionedEmployee extends AddEmployeeTransaction{

    public AddCommissionedEmployee(Integer employeeId, String name, String address) {
        super(employeeId, name, address);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
    
}

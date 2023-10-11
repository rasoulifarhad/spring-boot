package com.farhad.example.batchpayroll.domain.command.employee;

public class AddCommissionedEmployee extends AddEmployeeTransaction{

    private double salary;
    private double commissionRate;


    public AddCommissionedEmployee(
                    Integer employeeId,    
                    String name, 
                    String address,
                    double salary,
                    double commissionRate) {
        super(employeeId, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
    
}

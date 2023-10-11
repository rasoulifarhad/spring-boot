package com.farhad.example.batchpayroll.domain.command.employee;

public class AddHourlyEmployee extends AddEmployeeTransaction{

    private double hourlyRate;


    public AddHourlyEmployee(
                    Integer employeeId, 
                    String name, 
                    String address, 
                    double hourlyRate) {
        super(employeeId, name, address);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}

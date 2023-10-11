package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class HourlyClassification implements PaymentClassification{
    
    private double hourlyRate;
    private List<TimeCard>  timeCards = new ArrayList<>();
    @Override
    public double getSalary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSalary'");
    }
    
}

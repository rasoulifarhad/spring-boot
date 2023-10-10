package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.farhad.example.batchpayroll.domain.model.Pay;

import lombok.Data;

@Data
public class HourlyClassification implements PaymentClassification{
    
    private double hourlyRate;
    private List<TimeCard>  timeCards = new ArrayList<>();
    @Override
    public Pay calculatePay(Date date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatePay'");
    }
}

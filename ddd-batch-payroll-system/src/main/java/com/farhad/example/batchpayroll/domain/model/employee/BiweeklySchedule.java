package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

public class BiweeklySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDay(LocalDate date) {
        return false;
    }
    
}

package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

public class BiweeklySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDay(LocalDate date) {
        return false;
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate payPeriodEndDate) {
        return payPeriodEndDate.minusWeeks(2).plusDays(1);
    }
    
}

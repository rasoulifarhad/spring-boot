package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDay(LocalDate date) {
        return DayOfWeek.FRIDAY.compareTo(date.getDayOfWeek()) == 0;
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate payPeriodEndDate) {
        return payPeriodEndDate.minusWeeks(1);
    }
    
}

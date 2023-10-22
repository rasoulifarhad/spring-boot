package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;
import java.time.YearMonth;

public class MonthlySchedule implements PaymentSchedule {

    @Override
    public boolean isPayDay(LocalDate date) {
        YearMonth currebtYearMonth = YearMonth.from(date);
        return currebtYearMonth.atEndOfMonth().isEqual(date);
    }

    @Override
    public LocalDate getPayPeriodStartDate(LocalDate payPeriodEndDate) {
        return payPeriodEndDate.minusMonths(1).plusDays(1);
    }
    
}

package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.LocalDate;

public interface PaymentSchedule {
    boolean isPayDay(LocalDate date);

	LocalDate getPayPeriodStartDate(LocalDate payPeriodEndDate);
}

package com.farhad.example.batchpayroll.domain.model.employee;

import java.time.Instant;

public interface PaymentSchedule {
    boolean isPayDay(Instant date);
}

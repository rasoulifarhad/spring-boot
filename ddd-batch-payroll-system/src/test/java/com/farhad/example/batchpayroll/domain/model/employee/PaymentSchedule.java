package com.farhad.example.batchpayroll.domain.model.employee;

import java.util.Date;

public interface PaymentSchedule {
    boolean isPayDay(Date date);
}

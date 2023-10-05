package com.farhad.example.batchpayroll.oldway;

public interface Employee {
    EmployeeId id();
    String name();
    Amount salary();
    PayType payType();
    Amount calculatePay();

    void postPayment();
}

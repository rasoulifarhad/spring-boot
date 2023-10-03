package com.farhad.example.dddbank.domain.shared.exceptions;

public class MinimumBalanceException extends BusinessException {
    // New balance {0} EUR would become lower than minimum balance {1} EUR.
    // Amount MinimumBalance;
    //     Amount newBalance;
}

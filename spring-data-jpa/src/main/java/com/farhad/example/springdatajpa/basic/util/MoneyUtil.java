package com.farhad.example.springdatajpa.basic.util;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

public class MoneyUtil {

    public static BigDecimal extractAmount(MonetaryAmount monetaryAmount) {
        if (monetaryAmount == null) {
            return null;
        }
        return monetaryAmount.getNumber().numberValue(BigDecimal.class);
    }

    public static String extractCurrencyCode(MonetaryAmount monetaryAmount) {
        if (monetaryAmount == null) {
            return null;
        }
        return monetaryAmount.getCurrency().getCurrencyCode();
    }
    
}

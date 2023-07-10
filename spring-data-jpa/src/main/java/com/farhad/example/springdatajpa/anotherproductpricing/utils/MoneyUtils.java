package com.farhad.example.springdatajpa.anotherproductpricing.utils;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

public class MoneyUtils {
    
    public static BigDecimal extractAmount(MonetaryAmount monetaryAmount) {
        Objects.requireNonNull(monetaryAmount);
        return monetaryAmount.getNumber().numberValue(BigDecimal.class);
    }

    public static String extractCurrencyCode(MonetaryAmount monetaryAmount) {
        Objects.requireNonNull(monetaryAmount);
        return monetaryAmount.getCurrency().getCurrencyCode();
    }

    public static List<CurrencyUnit> getAllCurrencies() {
        List<CurrencyUnit> currencies = 
            Currency.getAvailableCurrencies().stream()
                        .map(c -> Money.of(1, c.getCurrencyCode()))
                        .map(MonetaryAmount::getCurrency)
                        .sorted()
                        .collect(toList());
        currencies.forEach(c -> System.out.printf("%s  %d\n",c.getCurrencyCode(), c.getDefaultFractionDigits() ));
        return currencies;
    }

    public static void main(String[] args) {
        getAllCurrencies();
    }
}

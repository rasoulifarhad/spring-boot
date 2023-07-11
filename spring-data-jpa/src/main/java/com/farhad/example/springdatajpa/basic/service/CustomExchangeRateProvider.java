package com.farhad.example.springdatajpa.basic.service;

import javax.money.CurrencyUnit;
import javax.money.convert.ConversionQuery;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ProviderContext;
import javax.money.convert.RateType;

import org.javamoney.moneta.convert.ExchangeRateBuilder;
import org.javamoney.moneta.spi.AbstractRateProvider;
import org.javamoney.moneta.spi.DefaultNumberValue;

public class CustomExchangeRateProvider extends AbstractRateProvider {

    public CustomExchangeRateProvider() {
        super(ProviderContext.of("Grand"));
    }

    @Override
    public ExchangeRate getExchangeRate(ConversionQuery conversionQuery) {

        CurrencyUnit baseCurrency = conversionQuery.getBaseCurrency();
        CurrencyUnit fromCurrency = conversionQuery.getCurrency();
        double rate  = baseCurrency.equals(fromCurrency) ? 1.0 :
                        "EUR".equals(baseCurrency.getCurrencyCode()) ? 0.8552 : 1.368;
        return new ExchangeRateBuilder(getContext().getProviderName(), RateType.ANY)
                        .setBase(baseCurrency)
                        .setTerm(conversionQuery.getCurrency())
                        .setFactor(DefaultNumberValue.of(rate))
                        .build();
    }
    
}

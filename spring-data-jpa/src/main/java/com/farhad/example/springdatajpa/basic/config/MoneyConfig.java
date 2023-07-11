package com.farhad.example.springdatajpa.basic.config;

import javax.money.convert.ExchangeRateProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.springdatajpa.basic.service.CustomExchangeRateProvider;

@Configuration
public class MoneyConfig {

    /**
     *  ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider("IMF");
     *  ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider("ECB", "IMF");
     *  ExchangeRate rate = rateProvider.getExchangeRate("CHF", "USD");
     * 
     *  CurrencyConversion conversion = rateProvider.getCurrencyConversion("CHF");
     *  MonetaryAmount amountInUSD = ....
     *  MonetaryAmount amountInCHF = amountInUSD.with(conversion);
     *
     * @return
     */
    @Bean
    public ExchangeRateProvider exchangeRateProvider() {
        // ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider("IMF");
        // return rateProvider;
        return new CustomExchangeRateProvider();
    }
}

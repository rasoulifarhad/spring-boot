package com.farhad.example.springdatajpa.basic.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;

import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import com.farhad.example.springdatajpa.basic.model.Contract;
import com.farhad.example.springdatajpa.basic.model.Fee;
import com.farhad.example.springdatajpa.basic.model.Invoice;
import com.farhad.example.springdatajpa.basic.repository.ContractRepository;
import com.farhad.example.springdatajpa.basic.repository.FeeRepository;
import com.farhad.example.springdatajpa.basic.repository.InvoiceRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvoiceService {
    
    private final FeeRepository feeRepository;
    private final ContractRepository contractRepository;
    private final InvoiceRepository invoiceRepository;
    private final ExchangeRateProvider exchangeRateProvider;

    public Optional<Invoice> createClientInvoice(String clientId, LocalDate date) {
        List<Fee> fees = feeRepository.findByClientId(clientId);
        if(fees.isEmpty()) {
            return Optional.empty();
        }

        Optional<Contract> optionalContract = contractRepository.findByClientId(clientId);
        if (!optionalContract.isPresent() ) {
            return Optional.empty();
        }

        Contract contract = optionalContract.get();
        String invoiceCurrency = contract.getInvoicCurrency().toString();
        CurrencyConversion conversion = exchangeRateProvider.getCurrencyConversion(invoiceCurrency);
        MonetaryAmount total = 
            fees.stream()
                .map(fee -> conversion.apply(fee.getAmount()))
                .reduce(Money.of(0, invoiceCurrency), MonetaryAmount::add);
        total = total.subtract(total.multiply(contract.getDiscountPercent()).divide(BigDecimal.valueOf(100)));
        total = total.with(Monetary.getDefaultRounding());
        Invoice invoice = createInvoice(clientId, date, total);
        return Optional.of(invoice);
    }

    private Invoice createInvoice(String clientId, LocalDate date, MonetaryAmount total) {
        return Invoice.builder()
                    .clientId(clientId)
                    .total(total)
                    .invoiceDate(date)
                    .dueDate(date.plusMonths(1))
                    .build();
    }
}

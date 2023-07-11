package com.farhad.example.springdatajpa.basic.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.money.Monetary;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.farhad.example.springdatajpa.basic.model.Fee;
import com.farhad.example.springdatajpa.basic.util.MoneyUtil;

@SpringBootTest
public class FeeRepositoryTest {

    @Autowired
    private FeeRepository feeRepository;

    
    @Test
    void testFindByClientId() {

        Fee fee1 = createFee("1", 100.0, "USD");
        Fee fee2 = createFee("2", 200.0, "EUR");
        Fee fee3 = createFee("1", 300.0, "GBP");
        List<Fee> fees = new ArrayList<>(Arrays.asList(new Fee[] {fee1, fee2, fee3}));
        feeRepository.saveAll(fees)  ;

        List<Fee> client1Fees = feeRepository.findByClientId("1");
        assertEquals(2, client1Fees.size());

        List<Fee> client2Fees = feeRepository.findByClientId("2");
        assertEquals(1, client2Fees.size());
        Fee fee = client2Fees.get(0);
        assertNotNull(fee.getCreated());
        assertEquals(200.0, MoneyUtil.extractAmount(fee.getAmount()).doubleValue(), 0.001);
        assertEquals(Monetary.getCurrency("EUR"), fee.getAmount().getCurrency());
    }


    private Fee createFee(String clientId, double amount, String currency) {

        return Fee.builder()
                .clientId(clientId)
                .amount(Money.of(amount, currency))
                .build();
    }
}

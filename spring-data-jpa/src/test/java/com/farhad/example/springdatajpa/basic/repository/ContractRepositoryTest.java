package com.farhad.example.springdatajpa.basic.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.farhad.example.springdatajpa.basic.model.Contract;

@SpringBootTest
public class ContractRepositoryTest {

    @Autowired
    private ContractRepository contractRepository;

    @Test
    void testFindByClientId() {
        String client1 = "client1";
        String client2 = "client2";

        createContract(client2,Currency.getInstance("USD"));
        assertFalse(contractRepository.findByClientId(client1).isPresent());
        assertTrue(contractRepository.findByClientId(client2).isPresent());
        Contract contract = contractRepository.findByClientId(client2).get();
        assertEquals(new BigDecimal("0.00"), contract.getDiscountPercent());
    }

    @Test 
    public void missingRequiredProperty() {
        assertThrows(Exception.class,
                     () -> createContract("client", null));
    }

    private Contract createContract(String client2, Currency currency) {
        Contract contract = Contract.builder()
                    .clientId(client2)
                    .invoicCurrency(currency)
                    .build();
        return contractRepository.save(contract);
    }
}

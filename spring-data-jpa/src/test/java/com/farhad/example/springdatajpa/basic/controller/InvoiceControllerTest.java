package com.farhad.example.springdatajpa.basic.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.farhad.example.springdatajpa.basic.model.Contract;
import com.farhad.example.springdatajpa.basic.model.Fee;
import com.farhad.example.springdatajpa.basic.repository.ContractRepository;
import com.farhad.example.springdatajpa.basic.repository.FeeRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InvoiceControllerTest {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private TestRestTemplate template;
    
    @Test
    void testCreateInvoice() {
        String clientId = "abc";
        createContract(clientId);

        Fee fee1 = createFee(clientId, 100.12, "USD");
        Fee fee2 = createFee(clientId, 150.55, "EUR");
        Fee fee3 = createFee(clientId, 200.77, "GBP");
        List<Fee> fees = new ArrayList<>(Arrays.asList(new Fee[] {fee1, fee2, fee3}));
        feeRepository.saveAll(fees)  ;
        ResponseEntity<InvoiceDto> response = 
                        template.postForEntity("/invoices/" + clientId, 
                                                clientId,
                                                InvoiceDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        InvoiceDto invoice = response.getBody();
        assertEquals("USD", invoice.getCurrency());        
        assertEquals(invoice.getAmount().doubleValue(), 121.73, 0.0001);
    }

    @Test   
    void testCreateInvoiceNotFound() {
        String clientId = "notFountId";
        ResponseEntity<InvoiceDto> response = 
                    template.postForEntity("/invoices/" + clientId, 
                                                clientId,
                                                InvoiceDto.class );
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    private Fee createFee(String clientId, double amount, String currency) {
        return Fee.builder()
                    .clientId(clientId)
                    .amount(Money.of(BigDecimal.valueOf(amount), currency)) 
                    .build();
    }
    private Contract createContract(String clientId) {
        Contract c =  Contract.builder()
                        .clientId(clientId)
                        .invoicCurrency(Currency.getInstance("USD"))
                        .discountPercent(BigDecimal.TEN)
                        .build();
        return contractRepository.save(c);
    }

}

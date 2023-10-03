package com.farhad.example.dddbank.infrastructure.persistence.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.dddbank.domain.model.AccountAccess;
import com.farhad.example.dddbank.domain.model.Client;
import com.farhad.example.dddbank.domain.service.BankService;
import com.farhad.example.dddbank.domain.shared.Amount;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Transactional
@RequiredArgsConstructor
public class ApplicationController {
    
    private final BankService bankService;

    private final Converter converter = new Converter();

    @GetMapping("/banks/pair")
    public ResponseEntity<ClientResource[]> create2Clients() {
        final long clientId = randomNumber();
        final Client firstClient = bankService.createClient("User:" + clientId, randomBirthDate());
        log.info("First client: {}", firstClient);
        if(clientId % 3 == 0) {
            throw new RuntimeException(String.format("Exception after creating %s. Should have been rolled back.", firstClient));
        }

        final Client secondClient = bankService.createClient("User:" + randomNumber(), randomBirthDate());
        log.info("Second client: {}", secondClient);
        final List<Client> clients = bankService.findAllClients();
        return ResponseEntity.ok(converter.clientsToResources(clients));
    }

    @GetMapping("/banks/clients")
    public ResponseEntity<ClientResource> createClient(@RequestBody ClientResource clientResource) {
        Objects.requireNonNull(clientResource);
        if(clientResource.getId() != null) {
            throw new RuntimeException(
                String.format("The client to be created with username %s must not have an ID, but has %s",
                        clientResource.getUsername(), 
                        clientResource.getId()));
        }
        final Client client = bankService.createClient(clientResource.getUsername(), 
                                    converter.toLocaldate(clientResource.getBirthDate()));
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(converter.toClientResource(client));


    }

    @DeleteMapping("/banks/clients/{username}")
    public ResponseEntity<Void> deleteClient(@PathVariable final String username) {
        bankService.deleteClient(
            bankService.findClient(username));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/banks/clients")
    public ResponseEntity<ClientResource[]> findClients(
                @RequestParam(name = "fromBirth", defaultValue = "") final String fromBirth,
                @RequestParam(name = "minBalance", defaultValue = "") final String minBalance) {

        List<Client> clients =  bankService.findClients(
                        converter.toLocaldate(fromBirth), 
                        new Amount(Double.parseDouble(minBalance)));
        return ResponseEntity.ok(converter.clientsToResources(clients));
    }

    @PostMapping("/clients/accounts/{username}")
    public ResponseEntity<AccountAccessResource> createAccount(@PathVariable final String username,
                    @RequestBody final String accountName) {
        AccountAccess accountAccess = bankService.createAccount(username, accountName);
        return new ResponseEntity<AccountAccessResource>(
                    new AccountAccessResource(accountAccess), 
                    HttpStatus.CREATED);
    }

    @PostMapping("/client/deposit/{username}")
    public ResponseEntity<Void> deposit(@RequestBody final DepositCommand command,
                                        @PathVariable final String username) {
        bankService.deposit(username, command.getAccountNo(), command.getAmount());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/client/transfer/{username}")
    public ResponseEntity<Void> transfer(@RequestBody final TransferCommand command,
                                        @PathVariable final String username) {
        bankService.transfer(username, 
                        command.getSrcAccountNo(), 
                        command.getDestAccountNo(),
                        command.getAmout());
        return ResponseEntity.noContent().build();
    }

    private Client generateRandomClient() {
        long number = randomNumber();
        LocalDate birthDate = randomBirthDate();
        return null;
    }

    private LocalDate randomBirthDate() {
        final long nowEpochDay = LocalDate.now().toEpochDay();
        final int minYears = 18;
        final int maxYears = 100;
        final long minEpochDay = nowEpochDay - 365 * minYears;
        final long maxEpochDay = nowEpochDay - 365 * maxYears;
        final long randomEpochDay = ThreadLocalRandom.current().nextLong(minEpochDay, maxEpochDay);
        return LocalDate.ofEpochDay(randomEpochDay);

    }

    private long randomNumber() {
        return System.currentTimeMillis() % 100;
    }
}

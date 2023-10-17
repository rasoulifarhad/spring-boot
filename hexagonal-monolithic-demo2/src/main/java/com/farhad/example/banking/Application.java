package com.farhad.example.banking;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.farhad.example.banking.domain.model.Account;
import com.farhad.example.banking.domain.port.outgoing.PersistAccount;
import com.farhad.example.banking.domain.port.outgoing.RetrieveAccount;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    public CommandLineRunner bootstrapData(PersistAccount persistAccount, RetrieveAccount retrieveAccount) {
        return (args) -> {
            BigDecimal initialBalance = BigDecimal.valueOf(1000);
            Account bankAccount = new Account(0L, initialBalance);
            persistAccount.save(bankAccount);
        };
    }	

}

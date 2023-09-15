package com.farhad.example.hexagonalbankaccount;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.farhad.example.hexagonalbankaccount.adapters.persistence.SpringDataBankAccountRepository;
import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.BankAccount;
import com.farhad.example.hexagonalbankaccount.application.domain.Money;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner bootstrapData(SpringDataBankAccountRepository repository) {
		return args -> {
			Money amount = Money.of(19, 49);
			BankAccount account = new BankAccount(new AccountId(9L), amount);
			repository.save(account);
		};
	}


}

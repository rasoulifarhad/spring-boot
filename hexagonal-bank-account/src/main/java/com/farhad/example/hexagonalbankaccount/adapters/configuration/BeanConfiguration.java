package com.farhad.example.hexagonalbankaccount.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.hexagonalbankaccount.adapters.persistence.BankAccountRepository;
import com.farhad.example.hexagonalbankaccount.application.service.BankAccountService;

@Configuration
public class BeanConfiguration {
	

	@Bean
	BankAccountService bankAccountService(BankAccountRepository bankAccountRepository) {
		return new BankAccountService(bankAccountRepository, bankAccountRepository);
	}
}

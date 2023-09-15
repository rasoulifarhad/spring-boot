package com.farhad.example.hexagonalbankaccount.adapters.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.hexagonalbankaccount.adapters.persistence.SpringDataBankAccountRepository;
import com.farhad.example.hexagonalbankaccount.application.service.BankAccountService;

@Configuration
public class BeanConfiguration {
	

	@Bean
	BankAccountService bankAccountService(SpringDataBankAccountRepository repository) {
		return new BankAccountService(repository, repository);	
	}
}

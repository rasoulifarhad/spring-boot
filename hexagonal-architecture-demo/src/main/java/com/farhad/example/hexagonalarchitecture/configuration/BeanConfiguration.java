package com.farhad.example.hexagonalarchitecture.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.hexagonalarchitecture.domain.service.AccountService;
import com.farhad.example.hexagonalarchitecture.infrastructure.adapter.AccountRepositrory;

@Configuration
public class BeanConfiguration {
	
	@Bean
	AccountService bankAccountService(AccountRepositrory repositrory) {
		return new AccountService(repositrory, repositrory);
	}
}

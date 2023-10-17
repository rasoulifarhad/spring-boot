package com.farhad.example.banking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.banking.Application;
import com.farhad.example.banking.domain.service.AccountService;
import com.farhad.example.banking.infrastructure.persistence.jdbc.AccountRepository;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {
	

 	@Bean
    AccountService bankAccountService(AccountRepository repository) {
        return new AccountService(repository, repository);
    }	
}

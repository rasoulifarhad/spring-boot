package com.farhad.example.banking.infrastructure.persistence.mongo;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.farhad.example.banking.domain.model.Account;

@Profile("jpa")
public interface SpringDataBankAccountRepository extends MongoRepository<Account, Long	> {
	
}

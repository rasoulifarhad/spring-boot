package com.farhad.example.banking.infrastructure.persistence.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.farhad.example.banking.domain.model.Account;
import com.farhad.example.banking.domain.port.outgoing.PersistAccount;
import com.farhad.example.banking.domain.port.outgoing.RetrieveAccount;

@Component
@Profile("jpa")
public class AccountRepository implements PersistAccount, RetrieveAccount{

	private SpringJpaAccountRepository springJpaAccountRepository;

	@Override
	public Account load(Long accountNo) {
		return springJpaAccountRepository.findById(accountNo).orElse(null);
	}

	@Override

	public void save(Account account) {
		springJpaAccountRepository.save(account);
	}
	
}

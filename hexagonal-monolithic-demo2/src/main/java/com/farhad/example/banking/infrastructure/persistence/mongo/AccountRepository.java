package com.farhad.example.banking.infrastructure.persistence.mongo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.farhad.example.banking.domain.model.Account;
import com.farhad.example.banking.domain.port.outgoing.PersistAccount;
import com.farhad.example.banking.domain.port.outgoing.RetrieveAccount;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Profile("jpa")
public class AccountRepository implements PersistAccount, RetrieveAccount{

	private final SpringDataBankAccountRepository accountRepository;

	@Override
	public Account load(Long accountNo) {
		return accountRepository.findById(accountNo).orElse(null);
	}

	@Override

	public void save(Account account) {
		accountRepository.save(account);
	}
}

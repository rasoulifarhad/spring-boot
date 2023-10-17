package com.farhad.example.banking.infrastructure.persistence.jdbc;

import org.springframework.stereotype.Component;

import com.farhad.example.banking.domain.model.Account;
import com.farhad.example.banking.domain.port.outgoing.PersistAccount;
import com.farhad.example.banking.domain.port.outgoing.RetrieveAccount;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountRepository implements PersistAccount, RetrieveAccount {

	private final SpringDataAccountRepository springDataAccountRepository;
	 
	@Override
	public Account load(Long accountNo) {
		return springDataAccountRepository.findByAccountNo(accountNo);
	}

	@Override
	public void save(Account account) {
		springDataAccountRepository.save(account);
	}
	
}

package com.farhad.example.hexagonalarchitecture.infrastructure.adapter;

import org.springframework.stereotype.Component;

import com.farhad.example.hexagonalarchitecture.domain.model.Account;
import com.farhad.example.hexagonalarchitecture.domain.port.outgoing.PersistAccount;
import com.farhad.example.hexagonalarchitecture.domain.port.outgoing.RetrieveAccount;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountRepositrory implements RetrieveAccount, PersistAccount{

	private final SpringDataAccountRepository repository;

	@Override
	public void save(Account account) {
		repository.save(account);
	}

	@Override
	public Account load(Long accountNo) {
		return repository.findByAccountNo(accountNo);
	}
	

}

package com.farhad.example.hexagonalbankaccount.application.service;

import java.util.NoSuchElementException;

import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.BankAccount;
import com.farhad.example.hexagonalbankaccount.application.domain.Money;
import com.farhad.example.hexagonalbankaccount.application.port.incoming.DepositUseCase;
import com.farhad.example.hexagonalbankaccount.application.port.incoming.WithdrawUseCase;
import com.farhad.example.hexagonalbankaccount.application.port.outgoing.LoadAccountPort;
import com.farhad.example.hexagonalbankaccount.application.port.outgoing.PersistAccountPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BankAccountService implements DepositUseCase, WithdrawUseCase {
	
	private final LoadAccountPort loadAccountPort;
	private final PersistAccountPort persistAccountPort;
	
	@Override
	public boolean withdraw(AccountId id, Money amount) {
		BankAccount bankAccount = loadAccountPort.findById(id)
												.orElseThrow(NoSuchElementException::new);
		boolean hasWithdrawn = bankAccount.withdraw(amount);
		if(hasWithdrawn) {
			persistAccountPort.save(bankAccount);
		} 
		return hasWithdrawn;
	}
	
	@Override
	public void deposit(AccountId id, Money amount) {
		BankAccount bankAccount = loadAccountPort.findById(id)
												.orElseThrow(NoSuchElementException::new);
		bankAccount.deposit(amount);
		persistAccountPort.save(bankAccount);
	}
}

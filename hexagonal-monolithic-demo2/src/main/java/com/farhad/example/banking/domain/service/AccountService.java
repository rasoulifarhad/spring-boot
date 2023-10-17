package com.farhad.example.banking.domain.service;

import java.math.BigDecimal;

import com.farhad.example.banking.domain.model.Account;
import com.farhad.example.banking.domain.port.incoming.Deposit;
import com.farhad.example.banking.domain.port.incoming.Withdraw;
import com.farhad.example.banking.domain.port.outgoing.PersistAccount;
import com.farhad.example.banking.domain.port.outgoing.RetrieveAccount;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService implements Deposit, Withdraw {

	private final PersistAccount persistAccount;
	private final RetrieveAccount retrieveAccount;
	@Override
	public boolean withdraw(Long accountNo, BigDecimal withdrawalAmount) {
		Account account = retrieveAccount.load(accountNo);
		boolean withdrawSuccess = account.withdrawAmount(withdrawalAmount);
		if(withdrawSuccess) {
			persistAccount.save(account);
		}
		return withdrawSuccess;
	}

	@Override
	public void deposit(Long accountNo, BigDecimal depositAmount) {
		Account account = retrieveAccount.load(accountNo);
		account.depositAmount(depositAmount);
		persistAccount.save(account);
	}
	
}

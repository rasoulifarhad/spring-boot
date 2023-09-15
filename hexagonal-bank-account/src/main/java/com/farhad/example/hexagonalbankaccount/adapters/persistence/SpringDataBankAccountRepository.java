package com.farhad.example.hexagonalbankaccount.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.BankAccount;
import com.farhad.example.hexagonalbankaccount.application.port.outgoing.LoadAccountPort;
import com.farhad.example.hexagonalbankaccount.application.port.outgoing.PersistAccountPort;

public interface SpringDataBankAccountRepository extends  LoadAccountPort, PersistAccountPort ,JpaRepository<BankAccount, AccountId> {
	
}

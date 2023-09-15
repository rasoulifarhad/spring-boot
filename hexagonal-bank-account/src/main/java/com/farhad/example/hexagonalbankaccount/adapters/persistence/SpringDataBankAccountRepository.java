package com.farhad.example.hexagonalbankaccount.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.BankAccount;

public interface SpringDataBankAccountRepository extends JpaRepository<BankAccount, AccountId> {
	
}

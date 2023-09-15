package com.farhad.example.hexagonalbankaccount.application.port.outgoing;

import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.BankAccount;

public interface LoadAccountPort {
	Optional<BankAccount> load(AccountId id);	
}

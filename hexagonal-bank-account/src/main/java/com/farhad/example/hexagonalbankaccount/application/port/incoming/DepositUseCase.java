package com.farhad.example.hexagonalbankaccount.application.port.incoming;

import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.Money;

public interface DepositUseCase {
	void deposit(AccountId id, Money amount);
}

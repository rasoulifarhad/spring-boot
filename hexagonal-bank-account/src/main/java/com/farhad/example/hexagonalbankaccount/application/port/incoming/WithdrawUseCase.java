package com.farhad.example.hexagonalbankaccount.application.port.incoming;

import com.farhad.example.hexagonalbankaccount.application.domain.AccountId;
import com.farhad.example.hexagonalbankaccount.application.domain.Money;

public interface WithdrawUseCase {
	boolean withdraw(AccountId id, Money amount);
}

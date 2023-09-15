package com.farhad.example.hexagonalbankaccount.application.port.outgoing;

import com.farhad.example.hexagonalbankaccount.application.domain.BankAccount;

public interface PersistAccountPort {
	void save(BankAccount bankAccount);
}

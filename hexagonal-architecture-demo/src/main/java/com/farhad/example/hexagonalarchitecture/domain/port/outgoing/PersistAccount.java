package com.farhad.example.hexagonalarchitecture.domain.port.outgoing;

import com.farhad.example.hexagonalarchitecture.domain.model.Account;

// Create an interface named PersistAccount using which we save the account information. 
public interface PersistAccount {
	void save(Account account);
}

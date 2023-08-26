package com.farhad.example.hexagonalarchitecture.domain.port.outgoing;

import com.farhad.example.hexagonalarchitecture.domain.model.Account;

// Create an interface named RetrieveAccount using which we can retrieve account information. 
public interface RetrieveAccount {
	Account load(Long accountNo);
}

package com.farhad.example.banking.domain.port.outgoing;

import com.farhad.example.banking.domain.model.Account;

public interface RetrieveAccount {
	Account load(Long accountNo);
}

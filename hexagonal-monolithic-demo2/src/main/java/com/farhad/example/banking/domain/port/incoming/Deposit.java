package com.farhad.example.banking.domain.port.incoming;

import java.math.BigDecimal;

public interface Deposit {
	void deposit(Long accountNo, BigDecimal depositAmount);
}

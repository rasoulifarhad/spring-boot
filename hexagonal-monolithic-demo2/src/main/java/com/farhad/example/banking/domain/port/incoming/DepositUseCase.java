package com.farhad.example.banking.domain.port.incoming;

import java.math.BigDecimal;

public interface DepositUseCase {
	void deposit(Long accountNo, BigDecimal depositAmount);
}

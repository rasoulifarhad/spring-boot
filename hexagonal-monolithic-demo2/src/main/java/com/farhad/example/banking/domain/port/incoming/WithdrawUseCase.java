package com.farhad.example.banking.domain.port.incoming;

import java.math.BigDecimal;

public interface WithdrawUseCase {
	    boolean withdraw(Long accountNo, BigDecimal withdrawalAmount);
}

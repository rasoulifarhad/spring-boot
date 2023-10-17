package com.farhad.example.banking.domain.port.incoming;

import java.math.BigDecimal;

public interface Withdraw {
	    boolean withdraw(Long accountNo, BigDecimal withdrawalAmount);
}

package com.farhad.example.hexagonalarchitecture.domain.port.incoming;

import java.math.BigDecimal;

// Create an interface named Withdraw using which the customer can perform withdraw operation. 
public interface Withdraw {
	boolean withdraw(Long accountNo, BigDecimal withdrawalAmount);
}

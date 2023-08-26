package com.farhad.example.hexagonalarchitecture.domain.port.incoming;

import java.math.BigDecimal;

//  Create an interface named Deposit using which the customer can perform deposit operation. 
public interface Deposit {
	
	void deposit(Long accountNo, BigDecimal depositAmount);
}

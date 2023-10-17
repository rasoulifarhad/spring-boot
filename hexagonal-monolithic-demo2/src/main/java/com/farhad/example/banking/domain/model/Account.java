package com.farhad.example.banking.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	private long accountNo;
	private BigDecimal accountBalance;

	public boolean withdrawAmount(BigDecimal withdrawalAmount) {
		if(accountBalance.compareTo(withdrawalAmount) < 0) {
			return false;
		}
		accountBalance = accountBalance.subtract(withdrawalAmount);
		return true;
	}

	public void depositAmount(BigDecimal depositAmount) {
        accountBalance = accountBalance.add(depositAmount);
    }

}

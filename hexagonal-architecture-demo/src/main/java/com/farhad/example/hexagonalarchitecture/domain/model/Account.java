package com.farhad.example.hexagonalarchitecture.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Account {
	private Long accountNo;
	private BigDecimal accountBalance;

	public boolean withdrawAmount(BigDecimal withdrawalAmount) {
		if (accountBalance.compareTo(withdrawalAmount) < 0) {
			return false;
		}
		accountBalance = accountBalance.subtract(withdrawalAmount);
		return true;
	}

	public void depositAmount(BigDecimal depositAmount) {
		accountBalance = accountBalance.add(depositAmount);
	}
}

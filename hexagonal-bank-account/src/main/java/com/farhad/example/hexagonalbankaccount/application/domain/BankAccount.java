package com.farhad.example.hexagonalbankaccount.application.domain;

import java.util.Objects;

import lombok.Data;

@Data
public class BankAccount {
	
	private AccountId id;
	private Money balance;

	
	public BankAccount(AccountId id, Money balance) {
		Objects.requireNonNull(id, "id must not be null");
		Objects.requireNonNull(balance, "balance must not be null");
		this.id = id;
		this.balance = balance;
	}

	public boolean withdraw(Money amount) {
		try {
			balance = balance.sub(amount);			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void deposit(Money money) {
		balance = balance.add(money);	
	}
}

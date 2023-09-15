package com.farhad.example.hexagonalbankaccount.application.domain;

import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class BankAccount {

	@EmbeddedId
	@AttributeOverride( name = "value", column = @Column(name = "account_id"))
	private AccountId id;
	@Embedded
	@AttributeOverrides({	
		@AttributeOverride( name = "amount", column = @Column(name = "balance_amount"))
	})
	private Money balance;

	protected BankAccount() {

	}
	
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

package com.farhad.example.dddbank.infrastructure.persistence.rest;

import com.farhad.example.dddbank.domain.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResource {
 
	private Long accountNo;
	private String name;
	private double balance;

    public AccountResource(final Account account) {
        this.accountNo = account.accountNo().getNumber();
        this.name = account.getName();
        this.balance = account.getBalance().getValue();
    }
}

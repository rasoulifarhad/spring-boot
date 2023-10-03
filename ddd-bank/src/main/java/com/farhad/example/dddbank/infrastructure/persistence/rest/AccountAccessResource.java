package com.farhad.example.dddbank.infrastructure.persistence.rest;

import com.farhad.example.dddbank.domain.model.Account;
import com.farhad.example.dddbank.domain.model.AccountAccess;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountAccessResource {
    
    private String clientUsername;
	private boolean isOwner;
	private Long accountNo;
	private String accountName;
	private String accountBalance;
    
public AccountAccessResource(final AccountAccess entity) {
		final Account account = entity.getAccount();
		this.clientUsername = entity.getClient().getUsername();
		this.isOwner = entity.isOwner();
		this.accountNo = account.accountNo().getNumber();
		this.accountName = account.getName();
		this.accountBalance = Double.toString(account.getBalance().getValue());
	}    
    
}

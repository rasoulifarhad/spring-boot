package com.farhad.example.dddbank.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.farhad.example.dddbank.domain.shared.EntityBase;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountAccess extends EntityBase<AccountAccess> {
    
	@ManyToOne
	private Client client;

	private boolean isOwner;

	@ManyToOne
	private Account account;

    public AccountAccess(final Client client, final boolean isOwner, final Account account) {
        this.client = client;
        this.isOwner = isOwner;
        this.account = account;
    }    

    
}

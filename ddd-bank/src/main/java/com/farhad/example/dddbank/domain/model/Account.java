package com.farhad.example.dddbank.domain.model;

import javax.persistence.Entity;

import com.farhad.example.dddbank.domain.shared.Amount;
import com.farhad.example.dddbank.domain.shared.EntityBase;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Account extends EntityBase<Account>{
    
    private String  name;
    private Amount balance = Amount.ZERO;
    
    public Account(final String name) {
        this.name = name;
    }

    public AccountNo accountNo(){
        return new AccountNo(id);
    }

    public void deposit(Amount amount) {
        this.balance = balance.plus(amount);
    }

    public void withdrawn(Amount amount) {
        this.balance = balance.minus(amount);
    }

}

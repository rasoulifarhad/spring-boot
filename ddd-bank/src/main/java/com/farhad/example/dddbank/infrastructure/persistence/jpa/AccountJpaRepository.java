package com.farhad.example.dddbank.infrastructure.persistence.jpa;

import java.util.Optional;

import com.farhad.example.dddbank.domain.model.Account;
import com.farhad.example.dddbank.domain.model.AccountNo;
import com.farhad.example.dddbank.domain.model.AccountRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountJpaRepository  implements AccountRepository{

    private final SpringDataAccountJpaRepository repo;

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    @Override
    public Account save(Account account) {
        return repo.save(account);
    }

    @Override
    public Optional<Account> findByAccountNo(AccountNo accountNo) {
        return repo.findById(accountNo.getNumber());
    }
    
}

package com.farhad.example.dddbank.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import com.farhad.example.dddbank.domain.model.Account;
import com.farhad.example.dddbank.domain.model.AccountAccess;
import com.farhad.example.dddbank.domain.model.AccountAccessRepository;
import com.farhad.example.dddbank.domain.model.Client;
import com.farhad.example.dddbank.domain.shared.Amount;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountAccessJpaRepository implements AccountAccessRepository{

    private final SpringDataAccountAccessJpaRepository repo;

    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    @Override
    public AccountAccess save(AccountAccess accountAccess) {
        return repo.save(accountAccess);
    }

    @Override
    public void delete(AccountAccess accountAccess) {
        repo.delete(accountAccess);
    }

    @Override
    public List<AccountAccess> findManagedAccountsOf(Client client, boolean asOwner) {
        return repo.findAllByClientAndIsOwnerGreaterThanEqualOrderByIdDesc(client, asOwner);
    }

    @Override
    public List<AccountAccess> findFullAccounts(Amount minBalance) {
        return repo.findAllByAccountBalanceCentsGreaterThanEqualOrderByAccountBalanceCentsDescClientIdDesc(minBalance.getValue());
    }

    @Override
    public Optional<AccountAccess> find(Client client, Account account) {
        return repo.findOneByClientAndAccount(client, account);
    }
    
}

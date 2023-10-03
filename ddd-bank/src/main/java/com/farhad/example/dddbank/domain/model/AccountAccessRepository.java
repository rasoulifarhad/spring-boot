package com.farhad.example.dddbank.domain.model;

import java.util.List;
import java.util.Optional;

import com.farhad.example.dddbank.domain.shared.Amount;

public interface AccountAccessRepository {
   
    void deleteAll();
   
    AccountAccess save(AccountAccess accountAccess);
   
    void delete(AccountAccess accountAccess);
    
    // Finds all  AccountAccess objects, which the given client may manage
    List<AccountAccess> findManagedAccountsOf(Client client, boolean asOwner);
   
    // Finds accounts with a minimum balance.
	List<AccountAccess> findFullAccounts(final Amount minBalance);
   
    // Finds the access rights of the client for the account
	Optional<AccountAccess> find(Client client, Account account);        
}

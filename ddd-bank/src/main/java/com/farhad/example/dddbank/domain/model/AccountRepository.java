package com.farhad.example.dddbank.domain.model;

import java.util.Optional;

public interface AccountRepository {
    
    void deleteAll();
    Account save(Account account);
    Optional<Account> findByAccountNo(AccountNo accountNo);
}

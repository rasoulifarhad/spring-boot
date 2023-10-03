package com.farhad.example.dddbank.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.dddbank.domain.model.Account;
import com.farhad.example.dddbank.domain.model.AccountAccess;
import com.farhad.example.dddbank.domain.model.Client;

public interface SpringDataAccountAccessJpaRepository extends JpaRepository<AccountAccess, Long> {
    
	List<AccountAccess> findAllByClientAndIsOwnerGreaterThanEqualOrderByIdDesc(Client client, boolean asOwner);

	Optional<AccountAccess> findOneByClientAndAccount(Client client, Account account);

	//Optional<AccountAccess> findOneByClientAndAccount(Client client, Long accountId);

	List<AccountAccess> findAllByAccountBalanceCentsGreaterThanEqualOrderByAccountBalanceCentsDescClientIdDesc(
			long minCents);    
}

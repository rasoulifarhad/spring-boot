package com.farhad.example.banking.infrastructure.persistence.jpa;


import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farhad.example.banking.domain.model.Account;

@Repository
@Profile("jpa")
public interface SpringJpaAccountRepository extends JpaRepository<Account, Long> {
	


}

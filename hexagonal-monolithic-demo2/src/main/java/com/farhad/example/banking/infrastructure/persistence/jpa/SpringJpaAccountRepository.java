package com.farhad.example.banking.infrastructure.persistence.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farhad.example.banking.domain.model.Account;

@Repository
public interface SpringJpaAccountRepository extends JpaRepository<Account, Long> {
	


}

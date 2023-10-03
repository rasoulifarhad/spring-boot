package com.farhad.example.dddbank.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.dddbank.domain.model.Account;

public interface SpringDataAccountJpaRepository extends JpaRepository<Account, Long> {
    
    Optional<Account> findOneById(Long id);
    
    List<Account> findAllByOrderByIdAsc();    
}

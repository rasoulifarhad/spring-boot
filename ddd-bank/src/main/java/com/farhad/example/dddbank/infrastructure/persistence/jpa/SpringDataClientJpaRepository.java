package com.farhad.example.dddbank.infrastructure.persistence.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farhad.example.dddbank.domain.model.Client;

public interface SpringDataClientJpaRepository extends JpaRepository<Client, Long>{
    
    Optional<Client> findOneById(Long id);
    
    Optional<Client> findOneByUsername(String username);
    
    Optional<Client> findOneByUsernameAndBirthDate(String name, LocalDate birthDate);

    List<Client> findAllByOrderByIdDesc();

    List<Client> findAllByBirthDateGreaterThanEqualOrderByBirthDateDescIdDesc(LocalDate minDate);

    Optional<Client> findFirstByOrderByIdAsc();    
}

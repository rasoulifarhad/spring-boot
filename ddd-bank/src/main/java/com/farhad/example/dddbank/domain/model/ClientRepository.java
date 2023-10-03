package com.farhad.example.dddbank.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    
    void deleteAll();
    Client save(Client client);
    void delete(Client client);
    Optional<Client> findById(Long id);
    Optional<Client> findByUserName(String userName);
    List<Client> findAll();
    List<Client> findAllBornFrom(LocalDate minDate);
}

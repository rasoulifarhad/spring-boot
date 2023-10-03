package com.farhad.example.dddbank.infrastructure.persistence.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.farhad.example.dddbank.domain.model.Client;
import com.farhad.example.dddbank.domain.model.ClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientJpaRepository implements ClientRepository {

    private final SpringDataClientJpaRepository repo;
    @Override
    public void deleteAll() {
        repo.deleteAll();
    }

    @Override
    public Client save(Client client) {
        return repo.save(client);
    }

    @Override
    public void delete(Client client) {
        repo.delete(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Client> findByUserName(String userName) {
        return repo.findOneByUsername(userName);
    }

    @Override
    public List<Client> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Client> findAllBornFrom(LocalDate minDate) {
        return repo.findAllByBirthDateGreaterThanEqualOrderByBirthDateDescIdDesc(minDate);
    }
    
}

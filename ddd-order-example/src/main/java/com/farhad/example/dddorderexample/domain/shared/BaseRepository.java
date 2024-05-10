package com.farhad.example.dddorderexample.domain.shared;

import java.io.Serializable;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.validation.constraints.NotNull;

@NoRepositoryBean
public interface BaseRepository<Aggregate extends BaseAggregateRoot<Id>, Id extends Serializable> 
       extends JpaRepository<Aggregate, Id>,
                JpaSpecificationExecutor<Aggregate> {

    default @NotNull Aggregate getById(@NotNull Id id) {
        return findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}

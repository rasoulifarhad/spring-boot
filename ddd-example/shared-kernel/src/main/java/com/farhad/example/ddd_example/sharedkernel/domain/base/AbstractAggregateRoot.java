package com.farhad.example.ddd_example.sharedkernel.domain.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NonNull;

@MappedSuperclass
public abstract class AbstractAggregateRoot<ID extends DomainObjectId> extends AbstractEntity<ID> {
    
    @Transient
    @JsonIgnore
    private List<DomainEvent> domainEvents = new ArrayList<>();


    protected AbstractAggregateRoot(@NonNull AbstractAggregateRoot<ID> source) {
        super(source);
    }

    protected AbstractAggregateRoot(@NonNull ID id) {
        super(id);
    }

    protected void registerDomainEvent(@NonNull DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }

    @AfterDomainEventPublication
    protected void clearDomainEvents() {
        domainEvents.clear();
    }

    @DomainEvents
    protected Collection<DomainEvent> domainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }
}

package com.farhad.example.ddd_example.sharedkernel.domain.base;

import java.time.Instant;

import org.springframework.lang.NonNull;

public interface DomainEvent extends DomainObject {
    
    @NonNull
    Instant occurredOn();
}

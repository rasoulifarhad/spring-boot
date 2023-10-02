package com.farhad.example.ddd_example.sharedkernel.domain.base;

import org.springframework.lang.Nullable;

public interface ConcurrencySafeDomainObject extends DomainObject {
    
    @Nullable
    Long version();
}

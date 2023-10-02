package com.farhad.example.ddd_example.sharedkernel.domain.base;

import java.io.Serializable;

import org.springframework.lang.Nullable;


public interface IdentifiableDomainObject<ID extends Serializable> extends DomainObject {
    
    @Nullable
    ID getId();
}

package com.farhad.example.ddd_example.sharedkernel.domain.base;

public interface DeletableDomainObject extends DomainObject {
    
    void delete();
    boolean isDeleted();
}

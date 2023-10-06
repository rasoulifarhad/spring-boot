package com.farhad.example.scrummanagement.domain.model.base.event;

public class DomainEventPublisher {
    
    private static final DomainEventPublisher INSTANCE = new DomainEventPublisher();
    private DomainEventPublisher() {

    }

    public static DomainEventPublisher instance(){
        return INSTANCE;
    }

    public void publish(DomainEvent domainEvent ) {
        
    }
}

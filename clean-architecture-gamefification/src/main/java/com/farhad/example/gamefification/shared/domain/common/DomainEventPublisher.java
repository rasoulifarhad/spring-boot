package com.farhad.example.gamefification.shared.domain.common;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class DomainEventPublisher {
    
    private Set<DomainEventListener> listeners = new CopyOnWriteArraySet<>();

    public void addEventListener(DomainEventListener domainEventListener) {
        this.listeners.add(domainEventListener);
    }

    

    public void publishEvent(DomainEvent domainEvent) {
        listeners.stream().forEach(l -> l.run(domainEvent));
    }



    public Set<DomainEventListener> listeners() {
        return listeners;
    }
}

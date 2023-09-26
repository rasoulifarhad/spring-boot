package com.farhad.example.gamefification.shared.domain.common;


public abstract class DomainEventListener {
    public abstract void reactTo(DomainEvent domainEvent);
    public abstract boolean canRun(DomainEvent domainEvent);
    public abstract String identification();
    public void run(DomainEvent domainEvent) {
        if(canRun(domainEvent)) {
            reactTo(domainEvent);
        }
    }
}

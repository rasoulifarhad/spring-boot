package com.farhad.example.gamefification.shared.domain.listener;

import com.farhad.example.gamefification.shared.domain.common.DomainEvent;
import com.farhad.example.gamefification.shared.domain.common.DomainEventListener;
import com.farhad.example.gamefification.shared.domain.common.DomainEventType;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "identification", callSuper = false)
public class StudentIndicatedToClassRoomListener extends DomainEventListener {

    private String identification;

    
    public StudentIndicatedToClassRoomListener() {
        this.identification = identification();
    }

    @Override
    public void reactTo(DomainEvent domainEvent) {
        log.info(
            String.format(
                "\n===\n [StudentIndicatedToClassRoomListener-%s]:: Enviando email para o estudante...",
                        domainEvent.when()));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            log.error("intrupted exception: ", e);
        }
    }

    @Override
    public boolean canRun(DomainEvent domainEvent) {
        return domainEvent.eventType() == DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM;
    }

    @Override
    public String identification() {
        return getClass().getName();
    }
    
}
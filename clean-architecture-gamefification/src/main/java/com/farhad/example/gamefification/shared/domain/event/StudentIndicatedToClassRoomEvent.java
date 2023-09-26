package com.farhad.example.gamefification.shared.domain.event;

import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

import java.util.Map;

import com.farhad.example.gamefification.shared.domain.common.DomainEvent;
import com.farhad.example.gamefification.shared.domain.common.DomainEventType;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "cpf", callSuper = false)
public class StudentIndicatedToClassRoomEvent implements DomainEvent {

    private final String cpf;

    @Override
    public Map<String, String> info() {
        return unmodifiableMap(singletonMap("cpf", cpf));
    }

    @Override
    public DomainEventType eventType() {
        return DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM;
    }
    
}

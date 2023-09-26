package com.farhad.example.gamefification.academic.domain.event;

import static com.farhad.example.gamefification.shared.domain.common.DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM;
import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

import java.util.Map;

import com.farhad.example.gamefification.academic.domain.model.CPF;
import com.farhad.example.gamefification.shared.domain.common.DomainEvent;
import com.farhad.example.gamefification.shared.domain.common.DomainEventType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentRegisteredToClassRoomEvent implements DomainEvent {

    private final CPF cpf;

    @Override
    public Map<String, String> info() {
        return unmodifiableMap(singletonMap("cpf", cpf.getNumber()));
    }

    @Override
    public DomainEventType eventType() {
        return STUDENT_REGISTERED_TO_CLASS_ROOM;
    }
    
}

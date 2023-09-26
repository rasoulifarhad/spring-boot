package com.farhad.example.gamefification.shared.domain.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public interface DomainEvent {
    Map<String, String> info();
    DomainEventType eventType();

    default String when() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now());
    }

    default String compileInfo() {
        final Map<String, String> info = info();
        return String.join(": ",
                info.entrySet()
                    .stream()
                    .map(e -> 
                        String.format("key: %s, value: %s",e.getKey(), e.getValue())
                    )
                    .collect(Collectors.toList()));
    }
}

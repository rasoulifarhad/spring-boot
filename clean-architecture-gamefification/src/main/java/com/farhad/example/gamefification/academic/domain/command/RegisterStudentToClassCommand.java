package com.farhad.example.gamefification.academic.domain.command;

import org.springframework.stereotype.Component;

import com.farhad.example.gamefification.academic.domain.event.StudentRegisteredToClassRoomEvent;
import com.farhad.example.gamefification.academic.domain.model.Student;
import com.farhad.example.gamefification.academic.domain.repository.ClassRoomRepository;
import com.farhad.example.gamefification.shared.domain.common.DomainEventPublisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class RegisterStudentToClassCommand {
 
    private final DomainEventPublisher publisher;
    private final ClassRoomRepository repository;

    public void registerStudentToClass(Student student) {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            log.error("intrupted exception: ", e);
        }
        repository.registerStudent(student);
        publisher.publishEvent(new StudentRegisteredToClassRoomEvent(student.getCpf()));
    }
}

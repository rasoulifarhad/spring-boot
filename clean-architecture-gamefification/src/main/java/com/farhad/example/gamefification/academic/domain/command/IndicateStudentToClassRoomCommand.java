package com.farhad.example.gamefification.academic.domain.command;

import com.farhad.example.gamefification.academic.domain.model.Student;
import com.farhad.example.gamefification.academic.domain.repository.StudentIndicationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class IndicateStudentToClassRoomCommand {
    
    private final StudentIndicationRepository repository;

    public void indicateStudent(Student student ) {
        log.info("Indicating student " + student.getCpf().getNumber());
        repository.indicate(student);
        log.info("Student " + student.getCpf().getNumber() + " indicated.");
    }
}

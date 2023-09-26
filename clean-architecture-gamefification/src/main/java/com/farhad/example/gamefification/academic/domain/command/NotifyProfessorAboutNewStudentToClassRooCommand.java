package com.farhad.example.gamefification.academic.domain.command;

import com.farhad.example.gamefification.academic.domain.model.Student;
import com.farhad.example.gamefification.academic.domain.repository.ProfessorNotifyerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class NotifyProfessorAboutNewStudentToClassRooCommand {
    
    private final ProfessorNotifyerRepository repository;

    public void notify(Student student) {
        log.info(String.format("\n professor has been just notified about the new student. CPF: %s",
        student.getCpf().getNumber()));

        repository.notifyProfessor(student);
    }
}

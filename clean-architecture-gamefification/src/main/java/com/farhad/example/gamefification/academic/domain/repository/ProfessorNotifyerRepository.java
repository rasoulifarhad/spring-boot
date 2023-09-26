package com.farhad.example.gamefification.academic.domain.repository;

import com.farhad.example.gamefification.academic.domain.model.Student;

public interface ProfessorNotifyerRepository {
    void notifyProfessor(Student student);
}

package com.farhad.example.gamefification.academic.infrastructure.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.farhad.example.gamefification.academic.domain.model.CPF;
import com.farhad.example.gamefification.academic.domain.model.Student;
import com.farhad.example.gamefification.academic.domain.repository.ClassRoomRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassRoomRepositoryInMemory implements ClassRoomRepository {

    private Map<CPF, Student> students = new ConcurrentHashMap<>();

    @Override
    public void registerStudent(Student student) {
        
		log.info("Registering");
        students.put(student.getCpf(), student);
    }
    
}

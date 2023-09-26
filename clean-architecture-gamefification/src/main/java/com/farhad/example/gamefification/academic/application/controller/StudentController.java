package com.farhad.example.gamefification.academic.application.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.gamefification.academic.application.dto.StudentInputDto;
import com.farhad.example.gamefification.academic.domain.command.IndicateStudentToClassRoomCommand;
import com.farhad.example.gamefification.academic.domain.command.RegisterStudentToClassCommand;

import lombok.RequiredArgsConstructor;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    
	private final IndicateStudentToClassRoomCommand indicateSudentPort;

	private final RegisterStudentToClassCommand registerStudentPort;  
    
    @PostMapping(value="/indications")
    public ResponseEntity<String> indicateStudent(@Valid @RequestBody StudentInputDto studentInputDto) {
        indicateSudentPort.indicateStudent(studentInputDto.student());
        return ResponseEntity.ok("Student registered sucessfully");
    }
    
    @PostMapping(value="/registrations")
    public ResponseEntity<String> registerStudent(@Valid @RequestBody StudentInputDto studentInputDto) {
        registerStudentPort.registerStudentToClass(studentInputDto.student());
        return ResponseEntity.ok("Student registered sucessfully");

    }
}

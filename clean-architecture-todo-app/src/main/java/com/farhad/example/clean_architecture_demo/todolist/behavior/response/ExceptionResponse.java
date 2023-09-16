package com.farhad.example.clean_architecture_demo.todolist.behavior.response;

import java.time.Instant;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class ExceptionResponse {
	@NotNull
	Instant timestamp;

	int status;

	@NotNull
	String error;

	@NotNull
	String message;
}

package com.farhad.example.clean_architecture_demo.todolist.adapter;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.farhad.example.clean_architecture_demo.todolist.behavior.response.ExceptionResponse;

@ControllerAdvice
public class TodoListExceptionHandling {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handle(Exception exception) {
		return responseOf(exception, HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<ExceptionResponse> responseOf(Exception exception, HttpStatus httpStatus) {
		final Instant timestamp = Instant.now();
		final int status = httpStatus.value();
		final String error = httpStatus.getReasonPhrase();
		final String message = exception.getMessage();

		final ExceptionResponse response = new ExceptionResponse(timestamp, status, error, message);
		return new ResponseEntity<ExceptionResponse>(response, httpStatus);
	}
	
}

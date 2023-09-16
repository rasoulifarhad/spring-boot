package com.farhad.example.clean_architecture_demo.todolist.domain;

public class TodoListException extends RuntimeException {
	
	public TodoListException(String message) {
		super(message);
	}
}

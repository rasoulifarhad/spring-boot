package com.farhad.example.clean_architecture_demo.todolist.domain;

public class TodoListNotFoundException extends TodoListException {

	public TodoListNotFoundException(String message) {
		super(message);
	}
	
}

package com.farhad.example.clean_architecture_demo.todolist.domain;

public class IllegalTaskName extends TodoListException {
	
	public IllegalTaskName(String message) {
		super(message);
	}
}

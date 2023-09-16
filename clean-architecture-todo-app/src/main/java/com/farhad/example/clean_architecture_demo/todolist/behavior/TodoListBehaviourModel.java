package com.farhad.example.clean_architecture_demo.todolist.behavior;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.Model;

import com.farhad.example.clean_architecture_demo.todolist.domain.TodoLists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TodoListBehaviourModel implements BehaviorModel {

	private final TodoLists repository;
	@Override
	public Model model() {
		
	}
	
}

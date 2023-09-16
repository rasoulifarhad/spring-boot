package com.farhad.example.clean_architecture_demo.todolist.behavior;

import java.util.UUID;
import java.util.function.Consumer;

import com.farhad.example.clean_architecture_demo.todolist.behavior.request.ToggleTaskCompletionRequest;
import com.farhad.example.clean_architecture_demo.todolist.domain.Task.TaskId;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList.TodoListId;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoListNotFoundException;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoLists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ToggleTaskCompletion implements Consumer<ToggleTaskCompletionRequest> {

	private final TodoLists repository;

	@Override
	public void accept(ToggleTaskCompletionRequest request) {
		final UUID todoListUuid = request.getTodoListUuid();
		final UUID taskUuid = request.getTaskUuid();

		final TodoList todoList = 
			repository.findById(TodoListId.of(todoListUuid))
					.orElseThrow(() -> new TodoListNotFoundException("Repository doesn't contain a TodoList of id " + todoListUuid));
		todoList.toggleTaskCompletion(TaskId.of(taskUuid));
		repository.save(todoList);
	}
	
}

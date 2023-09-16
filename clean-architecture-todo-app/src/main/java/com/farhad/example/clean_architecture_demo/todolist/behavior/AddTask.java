package com.farhad.example.clean_architecture_demo.todolist.behavior;

import java.util.UUID;
import java.util.function.Function;

import javax.validation.constraints.NotNull;

import com.farhad.example.clean_architecture_demo.todolist.behavior.request.AddTaskRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.response.AddTaskResponse;
import com.farhad.example.clean_architecture_demo.todolist.domain.Task.TaskId;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList.TodoListId;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoListNotFoundException;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoLists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class AddTask  implements Function<AddTaskRequest, AddTaskResponse> {
	
		private final TodoLists repository;

	@Override
	public AddTaskResponse apply(@NotNull AddTaskRequest request) {  
		final UUID todoListUuid = request.getTodoListUuid();
		final String taskName = request.getTaskName();

		final TodoList todoList = 
			repository.findById(TodoListId.of(todoListUuid))
					.orElseThrow(() -> new TodoListNotFoundException("Repository doesn't contain a TodoList of id " + todoListUuid));
		TaskId taskId = todoList.addTask(taskName);
		repository.save(todoList);
		return new AddTaskResponse(taskId.getUuid());
	}

}

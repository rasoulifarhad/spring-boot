package com.farhad.example.clean_architecture_demo.todolist.adapter;

import java.util.UUID;

import org.requirementsascode.Behavior;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farhad.example.clean_architecture_demo.todolist.behavior.request.ListTasksRequest;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoListNotFoundException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListTasksGet {
	private final Behavior behavior;

	@GetMapping("/todolist/tasks")
	public Object listTasks(@RequestParam UUID todoListUuid) {
		final ListTasksRequest request = new ListTasksRequest(todoListUuid);
		final Object response = 
			behavior.reactTo(request)
				.orElseThrow(() -> new TodoListNotFoundException("Repository doesn't contain a TodoList of id " + todoListUuid));
		return response;
	}
}

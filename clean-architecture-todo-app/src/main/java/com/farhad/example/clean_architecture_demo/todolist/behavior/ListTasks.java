package com.farhad.example.clean_architecture_demo.todolist.behavior;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import com.farhad.example.clean_architecture_demo.todolist.behavior.request.ListTasksRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.response.ListTasksResponse;
import com.farhad.example.clean_architecture_demo.todolist.domain.Task;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList.TodoListId;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoListNotFoundException;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoLists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListTasks implements Function<ListTasksRequest, ListTasksResponse> {


	private final TodoLists repository;
	@Override
	public ListTasksResponse apply(ListTasksRequest request) {

		final UUID todoListUuid = request.getTodoListUuid();

		final TodoList todoList = 
			repository.findById(TodoListId.of(todoListUuid))
					.orElseThrow(() -> new TodoListNotFoundException("Repository doesn't contain a TodoList of id " + todoListUuid));
		final List<Task> tasks = todoList.listTasks();

		List<ListTasksResponse.Task> taskList = tasks.stream()
				.map(t -> new ListTasksResponse.Task(t.getId().getUuid(), t.getName(), t.isComoleted()))
				.collect(toList());
		return new ListTasksResponse(taskList);
	}
	
}

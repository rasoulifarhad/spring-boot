package com.farhad.example.clean_architecture_demo.todolist.behavior;

import java.util.function.Consumer;
import java.util.function.Function;

import org.requirementsascode.BehaviorModel;
import org.requirementsascode.Model;

import com.farhad.example.clean_architecture_demo.todolist.behavior.request.AddTaskRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.request.DeleteTaskRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.request.FilterTasksRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.request.FindOrCreateListRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.request.ListTasksRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.request.ToggleTaskCompletionRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.response.AddTaskResponse;
import com.farhad.example.clean_architecture_demo.todolist.behavior.response.FilterTasksResponse;
import com.farhad.example.clean_architecture_demo.todolist.behavior.response.FindOrCreateListResponse;
import com.farhad.example.clean_architecture_demo.todolist.behavior.response.ListTasksResponse;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoLists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TodoListBehaviourModel implements BehaviorModel {

	private final TodoLists repository;
	
	@Override
	public Model model() {
		return Model.builder()
					.user(FindOrCreateListRequest.class).systemPublish(findOrCreateList())
					.user(AddTaskRequest.class).systemPublish(addTask())
					.user(DeleteTaskRequest.class).system(deleteTask())
					.user(ToggleTaskCompletionRequest.class).system(toggleTaskCompletion())
					.user(ListTasksRequest.class).systemPublish(listTasks())
					.user(FilterTasksRequest.class).systemPublish(filterTasks())
					.build();
	}

	private Function<FindOrCreateListRequest, FindOrCreateListResponse> findOrCreateList() {
		return new FindOrCreateList(repository);
	}

	private Function<AddTaskRequest, AddTaskResponse> addTask() {
		return new AddTask(repository);
	}

	private Consumer<DeleteTaskRequest> deleteTask() {
		return new DeleteTask(repository);
	}

	private Consumer<ToggleTaskCompletionRequest> toggleTaskCompletion() {
		return new ToggleTaskCompletion(repository);
	}

	private Function<ListTasksRequest, ListTasksResponse> listTasks() {
		return new ListTasks(repository);
	}

	private Function<FilterTasksRequest, FilterTasksResponse> filterTasks() {
		return new FilterTasks(repository);
	}
	
}

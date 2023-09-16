package com.farhad.example.clean_architecture_demo.todolist.behavior.response;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class ListTasksResponse {
	
	@Value
	public static class Task  {
		@NotNull
		UUID uuid;

		@NotNull
		String name;

		@NotNull
		Boolean completed;

	}

	@NotNull
	List<Task> tasks;	
	
}

package com.farhad.example.clean_architecture_demo.todolist.behavior.request;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class ToggleTaskCompletionRequest {
	@NotNull
	UUID todoListUuid;

	@NotNull
	UUID taskUuid;
}

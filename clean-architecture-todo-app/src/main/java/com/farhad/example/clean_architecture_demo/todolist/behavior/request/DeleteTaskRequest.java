package com.farhad.example.clean_architecture_demo.todolist.behavior.request;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class DeleteTaskRequest {
	@NotNull
	UUID todoListUuid;

	@NotNull
	UUID taskUuid;

}

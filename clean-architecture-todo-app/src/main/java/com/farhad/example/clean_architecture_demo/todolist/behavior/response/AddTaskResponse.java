package com.farhad.example.clean_architecture_demo.todolist.behavior.response;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Value;


@Value
public class AddTaskResponse{
	@NotNull
	UUID taskUuid;
	
}

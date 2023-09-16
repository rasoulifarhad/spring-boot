package com.farhad.example.clean_architecture_demo.todolist.domain;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.jmolecules.ddd.types.Entity;

import com.farhad.example.clean_architecture_demo.todolist.domain.Task.TaskId;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

@Getter
@EqualsAndHashCode
public class Task implements Entity<TodoList, TaskId> {
	private final TaskId id;
	private final String name;
	private final boolean comoleted;


	@Value(staticConstructor = "of")
	public static class TaskId {
		@NotNull
		UUID uuid;	
	}


	Task(@NotNull TaskId id,@NotNull  String name, boolean comoleted) {
		this.id = id;
		this.name = name;
		this.comoleted = comoleted;
	}	

	
}

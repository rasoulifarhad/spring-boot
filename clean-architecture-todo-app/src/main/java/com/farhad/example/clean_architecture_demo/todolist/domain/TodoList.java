package com.farhad.example.clean_architecture_demo.todolist.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import com.farhad.example.clean_architecture_demo.todolist.domain.Task.TaskId;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList.TodoListId;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode
public class TodoList implements AggregateRoot<TodoList, TodoListId>{
	private final TodoListId id;
	private final List<Task> tasks;

	@Value(staticConstructor = "of")
	public static class TodoListId implements Identifier {
		@NotNull
		UUID uuid;
	}	

	
	public TodoList( @NotNull TodoListId id, @NotNull List<Task> tasks) {
		this.id = id;
		this.tasks = new ArrayList<>();
		tasks.forEach(t -> add(t.getId(), t.getName(), t.isComoleted()));
	}


	private TaskId add(TaskId taskId, String taskName, boolean isComoleted) {
		Task task = new Task(taskId, taskName, isComoleted);
		this.tasks.add(task);
		return task.getId();
	}


	public TodoList() {
		this(TodoListId.of(UUID.randomUUID()), new ArrayList<>());
	}


	@Override
	public TodoListId getId() {
		return id;
	}

	public List<Task> listTasks() {
		return Collections.unmodifiableList(tasks);
	}

	public TaskId addTask(String taskName) {
		if(taskName == null || taskName.trim().isEmpty())  {
			throw new IllegalTaskName("Please specify a non-null, non-whitespace task name!");
		}

		TaskId taskId = add(TaskId.of(UUID.randomUUID()), taskName, false);
		return taskId;
	}

	public void deleteTask(TaskId taskId) {
		Optional<Task> foundTask = findTask(taskId);
		foundTask.ifPresent(tasks::remove);
	}


	public List<Task> filterTasks(boolean completade) {
		final List<Task> resultTasks = tasks.stream()
										.filter(t -> completade == t.isComoleted())
										.collect(toList());
		return Collections.unmodifiableList(resultTasks);
	}

	public int size() {
		return tasks.size();
	}

	public void toggleTaskCompletion(TaskId taskId) {
		Optional<Task> optionalFoundTask = findTask(taskId);
		optionalFoundTask.ifPresent(foundTask -> {
			int foundTaskIndex = tasks.indexOf(foundTask);
			Task newTask = new Task(taskId, foundTask.getName(), !foundTask.isComoleted());
			tasks.set(foundTaskIndex, newTask);
		});
	} 

	private Optional<Task> findTask(TaskId taskId) {
		Optional<Task> foundTask = tasks.stream()
									.filter(t -> taskId.equals(t.getId()))
									.findFirst();
		return foundTask;
	}
}

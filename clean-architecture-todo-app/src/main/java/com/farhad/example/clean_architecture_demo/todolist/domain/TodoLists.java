package com.farhad.example.clean_architecture_demo.todolist.domain;

import java.util.Optional;

import org.jmolecules.ddd.types.Repository;

import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList.TodoListId;

// The code uses a jMolecues annotation: Repository. During build, the ByteBuddy plugin translates it to a Spring Data repository.
public interface TodoLists extends Repository<TodoList, TodoListId> {
	TodoList save(TodoList entity);
	Optional<TodoList> findById(TodoListId id);
	Iterable<TodoList> findAll();
}

package com.farhad.example.clean_architecture_demo.todolist.behavior;

import java.util.Iterator;
import java.util.UUID;
import java.util.function.Function;

import com.farhad.example.clean_architecture_demo.todolist.behavior.request.FindOrCreateListRequest;
import com.farhad.example.clean_architecture_demo.todolist.behavior.response.FindOrCreateListResponse;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoList;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoLists;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindOrCreateList implements Function<FindOrCreateListRequest, FindOrCreateListResponse>{

	private final TodoLists repository;

	@Override
	public FindOrCreateListResponse apply(FindOrCreateListRequest request) {
		final TodoList list = findOrCreateList();
		final UUID listUuid = list.getId().getUuid();
		
		return new FindOrCreateListResponse(listUuid);
	}

	private TodoList findOrCreateList() {
		Iterator<TodoList> foundListIt = repository.findAll().iterator();
		TodoList list = foundListIt.hasNext() ? foundListIt.next() : createAndSaveList();
		return list;
	}

	private TodoList createAndSaveList() {
		final TodoList list = new TodoList();
		repository.save(list);
		return list;
	}
	
}

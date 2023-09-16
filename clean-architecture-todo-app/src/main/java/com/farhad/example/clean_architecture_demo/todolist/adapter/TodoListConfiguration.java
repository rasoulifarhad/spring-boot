package com.farhad.example.clean_architecture_demo.todolist.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.farhad.example.clean_architecture_demo.todolist.behavior.TodoListBehaviourModel;
import com.farhad.example.clean_architecture_demo.todolist.domain.TodoLists;

// If the application uses external services, the configuration class is the place to create the concrete instances as 
// beans. And inject them into the behavior model.
@Configuration
public class TodoListConfiguration {
	
	@Bean
	TodoListBehaviourModel behaviourModel(TodoLists repository) {
		return new TodoListBehaviourModel(repository);
	}
}

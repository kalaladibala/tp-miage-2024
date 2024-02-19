package com.acme.todolist.application.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.application.port.out.LoadTodoItem;
import com.acme.todolist.domain.TodoItem;

@Component
public class GetTodoItemsService implements GetTodoItems {

	private LoadTodoItem loadTodoItem;

	@Inject
	public GetTodoItemsService(LoadTodoItem loadTodoItem) {
		this.loadTodoItem = loadTodoItem;

	}

	@Override
	public List<TodoItem> getAllTodoItems() {
		return this.loadTodoItem.loadAllTodoItems().stream()
				.map(item -> new TodoItem(item.getId(), item.getTime(), item.finalContent()))
				.collect(Collectors.toList());
	}

}

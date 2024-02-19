package com.acme.todolist.application.port.in;

import java.util.List;

import com.acme.todolist.domain.TodoItem;

public interface GetTodoItems {
	
	/**
	 * 
	 * @return tous les items
	 */
	List<TodoItem> getAllTodoItems();

}

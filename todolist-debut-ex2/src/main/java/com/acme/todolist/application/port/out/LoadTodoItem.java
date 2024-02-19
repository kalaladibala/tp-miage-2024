package com.acme.todolist.application.port.out;

import java.util.List;

import com.acme.todolist.domain.TodoItem;

/**
 * Charge des todoitems depuis une source de persistence
 * @author bflorat
 *
 */
public interface LoadTodoItem {
	
	/* Récupére tous les TodoItem */
	List<TodoItem> loadAllTodoItems();

}

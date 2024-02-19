package com.acme.todolist.application.port.out;

import com.acme.todolist.domain.TodoItem;

/**
 * Créé ou met à jour des TodoItem persistés
 * @author bflorat
 *
 */
public interface UpdateTodoItem {
	
	/**
	 * Stocke un nouveau TodoItem
	 * @param item
	 */
	void storeNewTodoItem(TodoItem item);

}

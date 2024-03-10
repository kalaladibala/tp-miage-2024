package com.acme.todolist.adapters.rest_api;

import java.util.List;

import javax.inject.Inject;

import com.acme.todolist.application.port.in.AddTodoItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.acme.todolist.application.port.in.GetTodoItems;
import com.acme.todolist.domain.TodoItem;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {
	
	
	private GetTodoItems getTodoItemsQuery;
	private AddTodoItem addTodoItem;
	// A compléter
	
	
	@Inject
	//A compléter
	public TodoListController(GetTodoItems getTodoItemsQuery, AddTodoItem addTodoItem) {
		this.getTodoItemsQuery = getTodoItemsQuery;
		this.addTodoItem= addTodoItem;
	}
	
	@GetMapping("/todos")
	public List<TodoItem> getAllTodoItems() {
		return this.getTodoItemsQuery.getAllTodoItems();
	}
	
	
	// Endpoint de type POST vers "/todos"
	// A compléter
	@PostMapping ("/todos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void ajouterItem(@RequestBody TodoItem item) {
		// A compléter
this.addTodoItem.addTodoItem(item);	}
	
	
}

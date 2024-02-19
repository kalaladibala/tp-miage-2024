package com.acme.todolist.adapters.persistence;

import org.springframework.stereotype.Component;

import com.acme.todolist.domain.TodoItem;

@Component
public class TodoItemMapper {
	
	
	public TodoItem mapToTodoItem(TodoItemJpaEntity todoItemJpaEntity) {
		return new TodoItem(todoItemJpaEntity.getId(), todoItemJpaEntity.getTime(), todoItemJpaEntity.getContent());
	}
	
	public TodoItemJpaEntity mapToTodoItemJpaEntity(TodoItem todoItem) {
		return new TodoItemJpaEntity(todoItem.getId(), todoItem.getTime(), todoItem.getContent(),true);
	}

}

package com.acme.todolist.adapters.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;;

/**
 * DAO d'accès aux TodoItem
 * @author bflorat
 *
 */
public interface TodoItemRepository extends CrudRepository<TodoItemJpaEntity,String> {
			
	List<TodoItemJpaEntity> findAll(); 
	
	Optional<TodoItemJpaEntity> findById(String id);
	
	
}

package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.acme.todolist.adapters.persistence.TodoItemJpaEntity;
import com.acme.todolist.adapters.persistence.TodoItemRepository;
import com.acme.todolist.adapters.persistence.TodoItemPersistenceAdapter;
import com.acme.todolist.domain.TodoItem;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private TodoItemPersistenceAdapter persistenceAdapter;

	@MockBean
	private TodoItemRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testFinalContentNotLate() {
		// Créer un TodoItem avec un temps juste maintenant
		Instant time = Instant.now();
		TodoItem item = new TodoItem("1", time, "Test Task");

		// Vérifier que finalContent ne contient pas "[LATE!]"
		assertEquals("Test Task", item.finalContent());
	}

	@Test
	void testFinalContentLate() {
		// Créer un TodoItem avec un temps de plus de 24 heures dans le passé
		Instant time = Instant.now().minus(25, ChronoUnit.HOURS);
		TodoItem item = new TodoItem("1", time, "Test Task");

		// Vérifier que finalContent contient "[LATE!]"
		assertEquals("[LATE!] Test Task", item.finalContent());
	}

	@Test
	public void testStoreNewTodoItem() {
		// Créer un TodoItem
		TodoItem item = new TodoItem("1", Instant.now(), "Test Task");
		TodoItemJpaEntity entity = new TodoItemJpaEntity("1", Instant.now(), "Test Task", true);

		// Mock le comportement du repository
		when(repository.save(any(TodoItemJpaEntity.class))).thenReturn(entity);

		// Appeler la méthode de l'adaptateur de persistance
		persistenceAdapter.storeNewTodoItem(item);

		// Vérifier que la méthode save du repository a été appelée avec le bon paramètre
		verify(repository, times(1)).save(entity);
	}

	@Test
	public void testLoadAllTodoItems() {
		// Créer des entités simulées
		TodoItemJpaEntity entity1 = new TodoItemJpaEntity("1", Instant.now(), "Task 1", true);
		TodoItemJpaEntity entity2 = new TodoItemJpaEntity("2", Instant.now(), "Task 2", true);

		// Simuler le comportement du repository pour renvoyer ces entités
		when(repository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

		// Appeler la méthode de l'adaptateur de persistance
		List<TodoItem> items = persistenceAdapter.loadAllTodoItems();

		// Vérifier que les éléments retournés correspondent aux entités simulées
		assertEquals(2, items.size());
		assertEquals("Task 1", items.get(0).getContent());
		assertEquals("Task 2", items.get(1).getContent());
	}
}

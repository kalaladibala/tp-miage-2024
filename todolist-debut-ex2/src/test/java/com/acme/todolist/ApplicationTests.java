package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.acme.todolist.domain.TodoItem;

@SpringBootTest
class ApplicationTests {

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
}

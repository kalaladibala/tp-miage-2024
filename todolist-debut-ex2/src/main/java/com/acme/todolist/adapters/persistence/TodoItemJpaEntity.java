package com.acme.todolist.adapters.persistence;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Un TodoItem JPA
 * 
 * @author bflorat
 *
 */
@Entity
@Table(name = "todo_item")
public class TodoItemJpaEntity {

	@Id
	private String id;

	private Instant time;

	private String content;

	/** Flag permettant d'ignorer certains items en modifiant la base de donnée*/
	private Boolean visible;

	/** Constructeur vide imposé par JPA */
	public TodoItemJpaEntity() {
	}

	public TodoItemJpaEntity(String id, Instant time, String content, Boolean visible) {
		super();
		this.id = id;
		this.time = time;
		this.content = content;
		this.visible = visible;
	}

	@Override
	public String toString() {
		return "TodoItemJpaEntity [id=" + id + ", time=" + time + ", content=" + content + ", visible=" + visible + "]";
	}

	public String getId() {
		return id;
	}

	public Instant getTime() {
		return time;
	}

	public String getContent() {
		return content;
	}

	public Boolean getVisible() {
		return visible;
	}

}

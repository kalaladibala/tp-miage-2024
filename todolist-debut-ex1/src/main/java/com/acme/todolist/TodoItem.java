package com.acme.todolist;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Un item à faire, immuable
 * Sert à la fois d'entité JPA et de DTO (entrée/sortie des services Web)
 * 
 * @author bflorat
 *
 */
@Entity
public class TodoItem {
	
	@Id 
	private String id;
	
	private Instant time;
	
	private String content;
		

	public String getId() {
		return id;
	}

	public Instant getTime() {
		return time;
	}

	public String getContent() {
		return content;
	}
	
	/**
	 * Constructeur vide imposé par JPA, ne pas utiliser
	 */
	protected TodoItem() {	}
	
	public TodoItem(String id, Instant time, String content) {
		super();
		this.id = id;
		this.time = time;
		this.content = content;
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", time=" + time + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoItem other = (TodoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}


package com.acme.todolist.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Lanceur Spring boot
 * 
 * Note : comme cette classe n'est pas dans com.acme.todolist mais dans un sous package, il faut configurer finalement les 
 * différents composants nécessaires
 * @author bflorat
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.acme.todolist")
@EnableJpaRepositories(basePackages = "com.acme.todolist.adapters.persistence")
@EntityScan(basePackages = "com.acme.todolist.adapters.persistence")
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}

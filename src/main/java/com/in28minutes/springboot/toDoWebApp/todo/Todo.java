package com.in28minutes.springboot.toDoWebApp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;




//store them in Database
//1. Static list of todos -> Database (H2,MySQL)

@Entity //(we map this Bean to a database table). By uing the annotation Todo table will be automatically created in H2 database
public class Todo {         //we can also change the name of the table and the columns in the db. Jpa supports also mapping to comple relationhips
	
	@Id
	@GeneratedValue
	private long id;
	
	
	private String username;
	
	//minimum length required for the description field
	@Size(min=10, message="Enter at least 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	
	public Todo(long id, String username, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getTargetDate() {
		return targetDate;
	}


	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}


	public boolean isDone() {
		return done;
	}


	public void setDone(boolean done) {
		this.done = done;
	}


	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
	
	
	
	

}

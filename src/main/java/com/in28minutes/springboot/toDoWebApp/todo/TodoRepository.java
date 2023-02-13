package com.in28minutes.springboot.toDoWebApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepository extends JpaRepository<Todo,Long>{
	
	//Define a custom method
	public List<Todo> findByUsername(String username);
	

}

package com.in28minutes.springboot.toDoWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<>();
	
	private static int todosCount= 0;
	
	//static list: Restaring of the server always lead to the initialization state of the list
	
	//initialization
	static {
		
		todos.add(new Todo(++todosCount,"validUser","Get AWS Certified",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount,"validUser","Learn Devops",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount,"validUser","Learn full stack development",LocalDate.now().plusYears(3),false));
	}
	
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate //we define a condition
		  =todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();		//convert todos to a stream and check condition for each one. At the end we convert the filtered ones to a list
	}
	
	
	public void addTodo(String username,String description, LocalDate targetDate, boolean done ) {
		
		Todo todo=new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
		
		
	}
	
	public void deleteById(long id) {
		//if todo.getId() ==id remove it
		// todo -> todo.getId() == id 
		Predicate<? super Todo> predicate //executes this predicate at every todo in the list
		  =todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}


	public Todo findById(Long id) {
		
		Predicate<? super Todo> predicate //we define a condition
		  =todo -> todo.getId() == id;
		  Todo todo=todos.stream().filter(predicate).findFirst().get();
		  return todo;
	}


	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());     //otherwise use getters and settters?
		todos.add(todo);
		
		
		
	}

}

package com.in28minutes.springboot.toDoWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<>();
	
	//initialization
	static {
		
		todos.add(new Todo(1,"Course provider A","Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(2,"Course provider A","Learn Devops",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(3,"Course provider A","Learn full stack development",LocalDate.now().plusYears(3),false));
	}
	
	
	public List<Todo> findByUsername(String username){
		return todos;		
	}

}

package com.in28minutes.springboot.toDoWebApp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
//we want the name of the user to be available in the todo page
@SessionAttributes("name")
public class TodoController {
	
  private TodoService todoService;
  
  		
public TodoController(TodoService todoService) {
	super();
	this.todoService = todoService;
}



@RequestMapping("/list-todos")
public String listAllTodos(ModelMap model) {
	List<Todo> todos=todoService.findByUsername("Course provider A");
	model.addAttribute("todos",todos);
	return "listTodos";
}
	
	
	

}

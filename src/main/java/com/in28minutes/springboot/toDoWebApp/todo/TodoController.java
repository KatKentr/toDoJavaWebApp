package com.in28minutes.springboot.toDoWebApp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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

//without HTTP method specified, it handles all type of requests GET, POST..
@RequestMapping(value="/add-todo", method=RequestMethod.GET)

public String showNewTodoPage(ModelMap model) {
	String username=(String)model.get("name");
    Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false); //we initialize a todo to be used in the jsp
    model.put("todo", todo);
	return "todo";
}

//we add a new toDo in the list and redirect the user to the /list-todos page
//Instead of binding to model map we can bind directly to the Todo Bean (form backing object)
//we can make use of the form backing object in the jsp as well: we need to use spring form tag library
@RequestMapping(value="/add-todo", method=RequestMethod.POST)
public String addNewTodo(ModelMap model,Todo todo) {
	String username=(String)model.get("name");
	todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
	return "redirect:list-todos";
}


	

}

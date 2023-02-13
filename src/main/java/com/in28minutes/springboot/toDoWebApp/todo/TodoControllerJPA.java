package com.in28minutes.springboot.toDoWebApp.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.List;

@Controller
//we want the name of the user to be available in the todo page
@SessionAttributes("name")
public class TodoControllerJPA {
	
  
  private TodoRepository todoRepository;
  
//Autowire todoRepository  		
public TodoControllerJPA(TodoRepository todoRepository) {
	super();

	this.todoRepository=todoRepository;
}


@RequestMapping("/list-todos")
public String listAllTodos(ModelMap model) {
	String username=getLoggedInUsername(model);
	List<Todo> todos=todoRepository.findByUsername(username);
	model.addAttribute("todos",todos);
	return "listTodos";
}

//without HTTP method specified, it handles all type of requests GET, POST..
@RequestMapping(value="/add-todo", method=RequestMethod.GET)
public String showNewTodoPage(ModelMap model) {
	String username=getLoggedInUsername(model);
    Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),false); //when we load the todo page, we create a new todo and map it to the form present. we initialize a todo to be used in the jsp
    model.put("todo", todo);                                             //This is also called one-side binding from the controller to the values shown in the form.
	return "todo";
}


//we add a new toDo in the list and redirect the user to the /list-todos page
//Instead of binding to model map we can bind directly to the Todo Bean (form backing object)
//we can make use of the form backing object in the jsp as well: we need to use spring form tag library
@RequestMapping(value="/add-todo", method=RequestMethod.POST)           //second-side binding: the values filled to the form need to be mapped to the post request. The text submitted by the user gets bound to the description field of the todo and added to the list
public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result) {//Two-way binding: from the Bean to the form, from the form to the Bean
	if (result.hasErrors()) {
		return "todo"; //if there is an error go back to the todo page
		
	}
	String username=getLoggedInUsername(model);
	todo.setUsername(username);
	todoRepository.save(todo);
	return "redirect:list-todos";
}

@RequestMapping("/delete-todo")
public String deleteTodo(@RequestParam Long id) {
	//Delete todo and redirect to the list todo page
	todoRepository.deleteById(id);
	return "redirect:list-todos";
}

@RequestMapping(value="/update-todo",method=RequestMethod.GET)
public String showUdpateTodoPage(@RequestParam Long id,ModelMap model) {
	//display the todo page
	Todo todo=todoRepository.findById(id).get(); //find the todo with this id, pass it in the todo jsp page using model
	model.put("todo", todo); 
	return "todo";
}

@RequestMapping(value="/update-todo", method=RequestMethod.POST)           //second-side binding: the values filled to the form need to be mapped to the post request. The text submitted by the user gets bound to the description field of the todo and added to the list
public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {//Two-way binding: from the Bean to the form, from the form to the Bean
	if (result.hasErrors()) {
		return "todo"; //if there is an error go back to the todo page
		
	}
	String username=getLoggedInUsername(model);
	todo.setUsername(username);
	todoRepository.save(todo);  //update todo
	return "redirect:list-todos";
}


private String getLoggedInUsername(ModelMap model) {
	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
}
	

}

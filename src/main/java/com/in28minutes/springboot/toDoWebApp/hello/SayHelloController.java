package com.in28minutes.springboot.toDoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//we need to tell Spring that this is a Bean
@Controller //Controller manages the requests
public class SayHelloController {
	
	@RequestMapping("/hello")
	@ResponseBody //although it worked also without thi annotation
	public String sayHello() {
		
		return "Hell!What are you learning today?";
		
	}
	
	
	// method mapped to URL., handles the request.  we will redirect to sayHello.jsp
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		
		//name of the jsp file
		return "sayHello";
		
	}
	

}

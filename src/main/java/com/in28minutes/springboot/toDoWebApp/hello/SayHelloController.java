package com.in28minutes.springboot.toDoWebApp.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//we need to tell Spring that this is a Bean
@RestController
public class SayHelloController {
	
	@RequestMapping("/hello")
	@ResponseBody //although it worked also without thi annotation
	public String sayHello() {
		
		return "Hell!What are you learning today?";
		
	}

}

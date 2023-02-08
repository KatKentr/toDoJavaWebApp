package com.in28minutes.springboot.toDoWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//http://localhost:8080/login?name=<write a name>
	@RequestMapping("/login")
	public String gotoLoginPage(@RequestParam String name,ModelMap model) {
		model.put("name",name);
		//System.out.println("Request param is" + name); //not recommended for prod code, use logger instead
		//we can see it in the console only if the logging level is debug for our package, in the application.properties file
		logger.debug("Request param is {}",name);
		return "login";
		
	}

}

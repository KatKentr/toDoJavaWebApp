package com.in28minutes.springboot.toDoWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private AuthenticationService authenticationService;
	// = new AuthenticationService();  initialization if we did not use Spring. We couple it manually with an instance of the class AuthenticationService
	
	//Constructor-based Injection
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}	
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String gotoLoginPage() {

		return "login";
		
	}
	
	

	@RequestMapping(value="/login",method = RequestMethod.POST)
	//we need a Model map to pass this information to the welcome page
	public String gotoWelcomePage(@RequestParam String name, String password, ModelMap model) {
		
		if (authenticationService.authenticate(name, password)) {
			
			    model.put("name",name);		        
		        //simple authentication logic
		        //name - validUser
		        //password-dummy
		        //else rediricted to the login page
		        
				return "welcome";
			
			
		} 
		
		model.put("errorMessage","Invalid credentials! Please try again");
		return "login";
       
		
	}

}

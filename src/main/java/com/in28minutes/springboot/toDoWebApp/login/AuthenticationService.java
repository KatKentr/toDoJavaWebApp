package com.in28minutes.springboot.toDoWebApp.login;

import org.springframework.stereotype.Service;

//Now Spring will create an instance of the AuthenticationService and autowire it in the LoginController with Contructor-based Injection
@Service
public class AuthenticationService {
	
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("validUser");
		boolean isValidPassword= password.equalsIgnoreCase("dummy");
		
		return isValidUserName && isValidPassword;
	}

}

package com.in28minutes.springboot.toDoWebApp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	//LDAP or Database
	//In Memory
	
	//InMemoryUserDetailsManager
	//InMemoryDetailsManager(UserDetails...users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		Function<String,String> passwordEncoder=input-> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				            .passwordEncoder(passwordEncoder)
		                    .username("validUser")
		                    .password("1234")
		                    .roles("USER","ADMIN")
		                    .build();
		
		return new InMemoryUserDetailsManager(userDetails);
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

}

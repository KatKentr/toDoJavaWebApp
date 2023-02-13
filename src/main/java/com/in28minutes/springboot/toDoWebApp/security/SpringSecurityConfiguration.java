package com.in28minutes.springboot.toDoWebApp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//SecurityFilterChain: defines a filter chain matched against every request
//SecurityFilterChain: all URLs are automatically protected and a login form is shon for unauthorized requests
//We need to add two more features To use H2: CSRF disable and Frames enable



@Configuration
public class SpringSecurityConfiguration {
	//LDAP or Database
	//In Memory
	
	//InMemoryUserDetailsManager
	//InMemoryDetailsManager(UserDetails...users)
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		UserDetails userDetails1 = createNewUser("validUser", "1234");
		UserDetails userDetails2 = createNewUser("Kat", "dummy");
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
		
	}


	private UserDetails createNewUser(String username, String password) {
		Function<String,String> passwordEncoder=input-> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				            .passwordEncoder(passwordEncoder)
		                    .username(username)
		                    .password(password)
		                    .roles("USER","ADMIN")
		                    .build();
		return userDetails;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
//When we override ecirutyFilterChain, we need to define entire chain again
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());   //ensure all Urls are protected
		
		http.formLogin(withDefaults());   //enable a Login form
		
		http.csrf().disable();      //diable CSRF
		http.headers().frameOptions().disable();   //enable use of frames
				
		return http.build();
		
	}

}

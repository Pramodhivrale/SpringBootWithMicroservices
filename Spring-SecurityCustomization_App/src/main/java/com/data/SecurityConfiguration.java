package com.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RestController;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration 
{
//	@Bean
//	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
//		
//		http.authorizeHttpRequests((request) -> request
//				.antMatchers("/","/login","/about", "/swagger-ui.html").permitAll()
//				.anyRequest().authenticated()
//		).formLogin();
//		
//		return http.build();
	
//	}

}
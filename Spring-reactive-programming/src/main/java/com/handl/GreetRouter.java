package com.handl;

import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetRouter 
{
//	@Bean
//	public RouterFunction<ServerResponse>route(Handler hndl)
//	{
//		return RouterFunctions
//			      .route(GET("/hello")
//			      .and(accept(MediaType.APPLICATION_JSON)), greeting::handaleGreeting);
//				
//				
//	}


}

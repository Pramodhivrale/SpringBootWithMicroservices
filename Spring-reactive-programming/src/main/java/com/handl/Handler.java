package com.handl;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.entity.Greeting;

import reactor.core.publisher.Mono;

public class Handler 
{
	Mono<ServerResponse> handaleGreeting()
	{
		return ServerResponse.ok()
				             .contentType(MediaType.APPLICATION_JSON)
				             .body(BodyInserters.fromValue(new Greeting("Hello world")));
				             
	}

}
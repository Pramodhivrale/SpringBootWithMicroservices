package com.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private Environment env;
  
	@GetMapping("/greet")
	public String greetMsf()
	{
		String property = env.getProperty("server.port");
		
		return "welcome"+ property;
	}
}

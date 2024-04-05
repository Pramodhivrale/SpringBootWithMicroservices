package com.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

	@Autowired
	private FeignClient feign;

	@Autowired
	private Environment env;

	@GetMapping("/welcome")
	public String welcomeMsg() {
		String property = env.getProperty("server.port");

		String welcome = "Welcome-" + property;

		String feignClient = feign.feignClient();

		return welcome + ", " + feignClient;
	}
}

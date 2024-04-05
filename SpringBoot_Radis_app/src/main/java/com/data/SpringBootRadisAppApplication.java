package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.data","com.controller","com.service","com.user"})
public class SpringBootRadisAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRadisAppApplication.class, args);
	}

}

package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.repo")
//@ComponentScan(basePackages = {"com.application","com.controller","com.entity","com.repo","com.req","com.runner","com.service","com.utility"})
@ComponentScan(basePackages = "com.*")
@EntityScan(basePackages = "com.entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

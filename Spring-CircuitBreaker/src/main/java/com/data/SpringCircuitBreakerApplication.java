package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableHystrix
public class SpringCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCircuitBreakerApplication.class, args);
	}

}

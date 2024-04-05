package com.data;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.cloud.openfeign.FeignClient(name = "MS-GREET-API")
public interface FeignClient 
{
	@GetMapping("/greet")
    public String feignClient();
}

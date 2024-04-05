package com.data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass 
{
	@GetMapping("/login-check")
	public String loginUser()
	{
		return "User Logged in Succesfully";
	}
	
	@GetMapping("/contact")
	public String ContactUs()
	{
		return "Contact Us on following mail : bank@gmail.com";
	}
	
	@GetMapping("/balance")
	public String bankBalance()
	{
		return "You have left __ balance";
	}
	
	@GetMapping("/transer")
	public String transferAmount()
	{
		return "Amount transferred !!!!!";
	}

}

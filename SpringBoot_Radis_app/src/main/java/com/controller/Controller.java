package com.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.ServiceClass;
import com.user.User;

@RestController
public class Controller 
{
	@Autowired
	private ServiceClass serviceClass;
	
    @PostMapping("/user")
	public String addUser(@RequestBody User  user)
	{
		return serviceClass.addUser(user);
	}
    
    @GetMapping("/user{userId}")
    public User getUser(Integer userId)
    {
    	return serviceClass.getuser(userId );
    }
    
    @GetMapping("users")
    public Collection<User> getAllUser()
    {
    	return serviceClass.getAllUsers();
    }

}
package com.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.user.User;

@Service
public class ServiceClass 
{
	
	HashOperations<String, Integer, User> opsForHash=null;
	public ServiceClass(RedisTemplate<String , User>  redisTemplate)
	{
            this.opsForHash= redisTemplate.opsForHash();	
	}
	
	//We  Can Use any of this code snipet
	//private HashOperations<String, Integer, User> opsForHash;
	
	
	public String addUser(User user)
	{
		opsForHash.put("USERS", user.getId(), user);
		return "User Added";
	}
	
	public User getuser(Integer userId) 
	{
	return	opsForHash.get("USERS",userId );
		
	}
	
	public Collection< User> getAllUsers()
	{
		Map<Integer, User> entries = opsForHash.entries("USERS");
		return entries.values();
		
	}

}

package com.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService
{
	
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		
		return new User("admin","$2a$12$D9RHQK37tSLLvC6fUA3rDu3geEfeT.PZxs03pv4ZR2UK0tW8XVKsO",new ArrayList<>());
		
	}
	

}

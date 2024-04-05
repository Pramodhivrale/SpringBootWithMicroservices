package com.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.util.UtilClass;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterClass extends OncePerRequestFilter
{
	@Autowired
	private UtilClass util;
	
	@Autowired
	private UserDetailsService userservice;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
                  
		String header = request.getHeader("Authorization");
		
		String username=null;
		String jwt=null;
		
		if(header != null  && header.startsWith("bearer "))
		{
			jwt = header.substring(7);
			username=util.extractUsername(jwt);
			
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() ==  null)
		{
			UserDetails byUsername = userservice.loadUserByUsername(username);
			
			 if (util.validateToken(jwt, byUsername)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                		byUsername, null, byUsername.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
		}
		filterChain.doFilter(request, response);
		
	}
	
	

}

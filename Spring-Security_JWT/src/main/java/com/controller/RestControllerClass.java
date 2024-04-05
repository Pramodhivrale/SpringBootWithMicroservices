package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.AuthenticationResponse;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import com.util.UtilClass;

@RestController
public class RestControllerClass 
{
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UtilClass util;

	@Autowired
	private UserDetailsService myUserDetailsService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					((UserDetails) authenticationRequest).getUsername(), ((UserDetails) authenticationRequest).getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(((UserDetails) authenticationRequest).getUsername());

		final String jwt = util.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
    
}
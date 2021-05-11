package com.example.demorest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demorest.model.AuthenticateReq;
import com.example.demorest.model.AuthenticateResponse;
import com.example.demorest.service.MyUserDetailsService;
import com.example.demorest.util.JwtUtil;

@RestController
public class HelloResource {
	
	@Autowired
	JwtUtil jwtTokenUtil;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	
	
	@RequestMapping("/welcome")
	public String hello() {
		return "Welcome ";
	}
	
	@RequestMapping(value ="/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateReq authenticateRequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword())); //we'll use it to authenticate for the first time using name and password
		}
		catch (BadCredentialsException e) {
			throw new Exception("incorrect username or password");
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticateRequest.getUsername());
		String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwt));
		
	}


}

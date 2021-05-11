package com.example.demorest.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demorest.service.MyUserDetailsService;
import com.example.demorest.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		
		
		
		
	}

}
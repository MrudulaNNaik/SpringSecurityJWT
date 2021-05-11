package com.example.demorest;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	
	
	@RequestMapping("/welcome")
	public String hello() {
		return "Welcome ";
	}

}

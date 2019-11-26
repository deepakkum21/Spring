package com.deepak.springsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {
	
	@GetMapping("/")
	public String getHello() {
		return("<h1>Hello Viewers<h1>");
	}
	
	@GetMapping("/user")
	public String getUser() {
		return("<h1>Hello USER<h1>");
	}
	
	
	@GetMapping("/admin")
	public String getAdmin() {
		return("<h1>Hello ADMIN<h1>");
	}

}

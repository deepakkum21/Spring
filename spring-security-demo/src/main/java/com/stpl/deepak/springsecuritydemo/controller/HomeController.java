package com.stpl.deepak.springsecuritydemo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stpl.deepak.springsecuritydemo.User;
import com.stpl.deepak.springsecuritydemo.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/home")
	public String home() {
		System.out.println("home");
		return "home";
	}
	
	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {
		userRepo.save(user);
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logout() {
		return "logout.jsp";
	}
	
	@RequestMapping("user")
	@ResponseBody
	public Principal user(Principal principal) {
		return principal;
	}

}

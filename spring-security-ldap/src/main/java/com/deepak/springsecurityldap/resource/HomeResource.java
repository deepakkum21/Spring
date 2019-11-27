package com.deepak.springsecurityldap.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

	@GetMapping("/")
	public String getIndexResource() {
		return "HOME PAGE";
	}
}

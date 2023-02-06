package com.kishore.restfulwebservices.security.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class BasicAuthSecurityResource {
	
	@GetMapping("/basicauth")
	public String basicAuth() {
		return "success";
	}

}

package com.security.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@EnableMethodSecurity
public class Controller {
	@GetMapping("/welcome")
	public String Welcome()
	{
		return "This is welcome page";
	}
	
	@GetMapping("/all")
	public String getAll()
	{
		return "Here we go";
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/user")
	public String onlyUser()
	{
		return "Only for User";
	}
	
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/admin")
	public String onlyAdmin()
	{
		return "Only for Admin";
	}
	
}
//
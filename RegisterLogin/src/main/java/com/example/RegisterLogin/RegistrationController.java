package com.example.RegisterLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
	@Autowired
	UserService uservice;
	
	@PostMapping("/register")
   public String registerUser(@RequestBody UserDTO uDto)
   {
	   User user = uservice.registerUser(uDto);
	return "success";
			   
   }
}

package com.RegisterLogin.Controller;

import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RegisterLogin.DTO.UserDTO;
import com.RegisterLogin.Entity.User;
import com.RegisterLogin.Event.RegComEvent;
import com.RegisterLogin.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {
	@Autowired
	UserService uservice;
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	@PostMapping("/register")
   public String registerUser(@RequestBody UserDTO uDto, final HttpServletRequest req)
   {
	   User user = uservice.registerUser(uDto);
	   publisher.publishEvent(new RegComEvent(user,applicationUrl(req)));
	   return "success";
			   
   }

	private String applicationUrl(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return "http://"+req.getServerName()+":"+req.getServerPort()+req.getServletContext();
	}
}

package com.RegisterLogin.Listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import com.RegisterLogin.Entity.User;
import com.RegisterLogin.Event.RegComEvent;
import com.RegisterLogin.Service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class RegComEventListener implements ApplicationListener<RegComEvent> {

	@Autowired
	UserService userService;
	
	@Override
	public void onApplicationEvent(RegComEvent event) {
		
		//CREATE THE VERIFICATION TOKEN
		User user = event.getUser();
		String tokenString = UUID.randomUUID().toString();
		userService.saveVerifyTookenForUser(tokenString, user);
		
		//SEND MAIL TO USER
		String urlString = event.getUrl() + "verifyReg?token=" + tokenString;
		log.info("click the link to verify your accouht");
	}

	
	
}

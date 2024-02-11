package com.RegisterLogin.Event;

import org.springframework.context.ApplicationEvent;

import com.RegisterLogin.Entity.User;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegComEvent extends ApplicationEvent {

	User user;
	String url;
	public RegComEvent(User user, String appURL) {
		super(user);
		this.user = user;
		this.url = appURL;
	}

	
	
}

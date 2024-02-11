package com.RegisterLogin.Service;

import com.RegisterLogin.DTO.UserDTO;
import com.RegisterLogin.Entity.User;

public interface UserService {

	User registerUser(UserDTO uDto);

	void saveVerifyTookenForUser(String tokenString, User user);
	
}

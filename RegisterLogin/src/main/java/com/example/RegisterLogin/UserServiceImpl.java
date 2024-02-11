package com.example.RegisterLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo uRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User registerUser(UserDTO uDto) {
		User user = new User();
		user.setEmail(uDto.getEmail());
		user.setFirstName(uDto.getFirstName());
		user.setLastName(uDto.getLastName());
		String pw = encoder.encode(uDto.getPassword());
		user.setPassword(pw);
		user.setRole("USER");
		
		return uRepo.save(user);
	}

}

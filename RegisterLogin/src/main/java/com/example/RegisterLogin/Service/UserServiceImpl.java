package com.RegisterLogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.RegisterLogin.DTO.UserDTO;
import com.RegisterLogin.Entity.User;
import com.RegisterLogin.Entity.VerificationToken;
import com.RegisterLogin.Repository.UserRepo;
import com.RegisterLogin.Repository.VerificationTokenRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo uRepo;
	
	@Autowired
	VerificationTokenRepo verifyRepo;
	
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

	@Override
	public void saveVerifyTookenForUser(String tokenString, User user) {
		VerificationToken verificationToken 
		= new VerificationToken(user,tokenString);
		verifyRepo.save(verificationToken);
	}

}

package com.RegisterLogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RegisterLogin.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
}

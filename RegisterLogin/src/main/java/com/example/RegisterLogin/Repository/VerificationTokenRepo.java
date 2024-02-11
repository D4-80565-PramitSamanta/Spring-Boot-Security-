package com.RegisterLogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RegisterLogin.Entity.VerificationToken;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Long>{
	
}

package com.security.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {


	Optional<UserInfo> findByName(String username);

}

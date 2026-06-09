package com.vardhan.mediconnect_backend.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vardhan.mediconnect_backend.auth.entity.User;

public interface UserRepository  extends JpaRepository<User,Long>{

	Optional<User> findByEmail(String email);
	
	boolean existsByEmail(String email);
}

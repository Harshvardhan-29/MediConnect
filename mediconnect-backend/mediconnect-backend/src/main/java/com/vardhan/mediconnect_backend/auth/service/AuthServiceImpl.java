package com.vardhan.mediconnect_backend.auth.service;

import org.springframework.stereotype.Service;

import com.vardhan.mediconnect_backend.auth.dto.RegisterRequest;
import com.vardhan.mediconnect_backend.auth.dto.RegisterResponse;
import com.vardhan.mediconnect_backend.auth.entity.User;
import com.vardhan.mediconnect_backend.auth.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	
	 public AuthServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	 @Override
	    public RegisterResponse register(RegisterRequest request) {

	        if (userRepository.existsByEmail(request.getEmail())) {
	            return new RegisterResponse("Email already exists");
	        }

	        User user = new User();

	        user.setName(request.getName());
	        user.setEmail(request.getEmail());
	        user.setPassword(request.getPassword());
	        user.setRole(request.getRole());

	        userRepository.save(user);

	        return new RegisterResponse("User registered successfully");
	    }
}

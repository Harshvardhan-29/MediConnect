package com.vardhan.mediconnect_backend.auth.service;

import org.springframework.stereotype.Service;

import com.vardhan.mediconnect_backend.auth.dto.RegisterRequest;
import com.vardhan.mediconnect_backend.auth.dto.RegisterResponse;
import com.vardhan.mediconnect_backend.auth.entity.User;
import com.vardhan.mediconnect_backend.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import com.vardhan.mediconnect_backend.auth.dto.LoginRequest;
import com.vardhan.mediconnect_backend.auth.dto.LoginResponse;

import com.vardhan.mediconnect_backend.auth.security.JwtService;

@Service
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

	public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
	}

	@Override
	public RegisterResponse register(RegisterRequest request) {

		if (userRepository.existsByEmail(request.getEmail())) {
			return new RegisterResponse("Email already exists");
		}

		User user = new User();

		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		userRepository.save(user);

		return new RegisterResponse("User registered successfully");
	}

	@Override
	public LoginResponse login(LoginRequest request) {

		Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

		if (optionalUser.isEmpty()) {
			return new LoginResponse("User not found", null);
		}

		User user = optionalUser.get();

		boolean passwordMatches = passwordEncoder.matches(request.getPassword(), user.getPassword());

		if (!passwordMatches) {
			return new LoginResponse("Invalid password", null);
		}

		String token = jwtService.generateToken(user.getEmail(),
												user.getRole().name());

		return new LoginResponse("Login successful", token);	}
}

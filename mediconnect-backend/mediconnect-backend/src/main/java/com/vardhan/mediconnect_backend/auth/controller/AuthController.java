package com.vardhan.mediconnect_backend.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vardhan.mediconnect_backend.auth.dto.RegisterRequest;
import com.vardhan.mediconnect_backend.auth.dto.RegisterResponse;
import com.vardhan.mediconnect_backend.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	public final AuthService authService;
	
	public AuthController(AuthService authService) {
	this.authService=authService;
	}
	
	@PostMapping("/register")
	 public ResponseEntity<RegisterResponse> register(
	            @RequestBody RegisterRequest request) {

	        RegisterResponse response =
	                authService.register(request);

	        return ResponseEntity.ok(response);
	    }
}

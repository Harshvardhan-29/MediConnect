package com.vardhan.mediconnect_backend.auth.service;

import com.vardhan.mediconnect_backend.auth.dto.RegisterRequest;
import com.vardhan.mediconnect_backend.auth.dto.RegisterResponse;
import com.vardhan.mediconnect_backend.auth.dto.LoginRequest;
import com.vardhan.mediconnect_backend.auth.dto.LoginResponse;
public interface AuthService {
	
	RegisterResponse register(RegisterRequest reuqest);
	LoginResponse login(LoginRequest request);
}

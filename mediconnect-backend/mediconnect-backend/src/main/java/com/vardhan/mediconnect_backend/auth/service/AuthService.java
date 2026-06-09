package com.vardhan.mediconnect_backend.auth.service;

import com.vardhan.mediconnect_backend.auth.dto.RegisterRequest;
import com.vardhan.mediconnect_backend.auth.dto.RegisterResponse;

public interface AuthService {
	
	RegisterResponse register(RegisterRequest reuqest);
}

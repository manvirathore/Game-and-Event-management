package com.fitrack.demo.service;

import com.fitrack.demo.DTO.AuthRequest;
import com.fitrack.demo.DTO.AuthResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity<AuthResponse> authenticateUser(AuthRequest authRequest) throws Exception;
}

package com.fitrack.demo.controller;

import com.fitrack.demo.DTO.AuthRequest;
import com.fitrack.demo.DTO.AuthResponse;
import com.fitrack.demo.DTO.BaseResponse;
import com.fitrack.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping(value = "/test")
    public ResponseEntity<BaseResponse> sayHelloToAll() {
        BaseResponse response = BaseResponse.builder()
                .message("Hello!! I am up and running!!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest request) throws Exception {
        return authService.authenticateUser(request);
    }
}

package com.fitrack.demo.controller;


import com.fitrack.demo.DTO.AuthRequest;
import com.fitrack.demo.DTO.AuthResponse;
import com.fitrack.demo.DTO.UserDTO;
import com.fitrack.demo.service.AuthService;
import  com.fitrack.demo.service.UserServiceImpl;
import com.fitrack.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/{userId}/follow")
    public ResponseEntity<UserDTO> followUser(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.followUser(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest request) throws Exception{
        return authService.authenticateUser(request);
    }
}


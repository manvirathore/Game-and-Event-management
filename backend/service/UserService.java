package com.fitrack.demo.service;

import com.fitrack.demo.DTO.UserRequest;
import com.fitrack.demo.DTO.UserResponse;
import com.fitrack.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    public ResponseEntity<UserResponse> createUser(UserRequest userRequest);
    Optional<User> findByname(String username);
    boolean existsByEmail(String email);

}

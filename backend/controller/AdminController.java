package com.fitrack.demo.controller;

import com.fitrack.demo.DTO.BaseResponse;
import com.fitrack.demo.DTO.UserRequest;
import com.fitrack.demo.DTO.UserResponse;
import com.fitrack.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public ResponseEntity<BaseResponse> sayHelloToAdmin() {
        BaseResponse response = BaseResponse.builder()
                .message("Hello Admin !! I am up and running!!")
                     .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }


}

package com.fitrack.demo.service;

import com.fitrack.demo.DTO.UserDTO;
import com.fitrack.demo.DTO.UserRequest;
import com.fitrack.demo.DTO.UserResponse;
import com.fitrack.demo.Mapper.UserMapper;
import com.fitrack.demo.model.User;
import com.fitrack.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<UserResponse> createUser (UserRequest userRequest) {

//        if (Objects.isNull(userRequest)) {
//
////            Log.error("User Request is null");
//
////            throw new BadRequestException("User Request is null");
//
//        }
//
////        if (userRepository.existsByEmail(userRequest.getEmail())) {
////
////            throw new UserAlreadyExistsException("User already exists with email:" + userRequest)
////        }
//
//        User userToSave = userMapper.mapToUser(userRequest);
//
//        userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
//
//        User savedUser = userRepository.save(userToSave);
//
//        UserResponse response = userMapper.mapToUserResponse(savedUser);
//
//        return new ResponseEntity<> (response, HttpStatus.CREATED);

        System.out.println(userRequest);

        User user = User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .email(userRequest.getEmail())
                .roles(userRequest.getRoles())
                .build();
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        System.out.println(userRequest);
        UserResponse userResponse = new UserResponse();
//        userResponse.setId(savedUser.getId());
        userResponse.setUsername(userRequest.getUsername());
//        userResponse.setEmail(savedUser.getEmail());
        userResponse.setRoles(savedUser.getRoles());

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);

    }

    @Override
    public Optional<User> findByname(String username) {
        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    public UserDTO followUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFollowers(user.getFollowers() + 1);
        return userMapper.toDTO(userRepository.save(user));
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}





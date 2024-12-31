package com.fitrack.demo.Mapper;

import com.fitrack.demo.DTO.UserDTO;
import com.fitrack.demo.DTO.GroupDTO;
import com.fitrack.demo.DTO.UserRequest;
import com.fitrack.demo.DTO.UserResponse;
import com.fitrack.demo.model.User;
import com.fitrack.demo.model.Group;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final GroupMapper groupMapper;

    @Autowired
    public UserMapper(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFollowers(user.getFollowers());
        List<GroupDTO> groupDTOs = user.getGroups().stream()
                .map(groupMapper::toDTO)
                .collect(Collectors.toList());
        userDTO.setGroups(groupDTOs);

        return userDTO;
    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setFollowers(userDTO.getFollowers());
        List<Group> groups = userDTO.getGroups().stream()
                .map(groupMapper::toEntity)
                .collect(Collectors.toList());
        user.setGroups(groups);

        return user;
    }

    public User mapToUser(UserRequest userRequest) {
        if(Objects.isNull(userRequest)) {
            return new User();
        }

        return User.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .roles(userRequest.getRoles())
                .build();
    }

    public UserResponse mapToUserResponse(User user) {
        if(Objects.isNull(user)) {
            return new UserResponse();
        }

        return UserResponse.builder()
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
    }
}

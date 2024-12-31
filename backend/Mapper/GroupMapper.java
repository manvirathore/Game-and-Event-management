package com.fitrack.demo.Mapper;

import com.fitrack.demo.DTO.GroupDTO;
import com.fitrack.demo.DTO.UserDTO;
import com.fitrack.demo.model.Group;
import com.fitrack.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(@Lazy UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public GroupDTO toDTO(Group group) {
        if (group == null) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setId(group.getId());
        groupDTO.setName(group.getName());
        List<UserDTO> userDTOs = group.getUsers().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
        groupDTO.setUsers(userDTOs);

        return groupDTO;
    }

    public Group toEntity(GroupDTO groupDTO) {
        if (groupDTO == null) {
            return null;
        }

        Group group = new Group();
        group.setId(groupDTO.getId());
        group.setName(groupDTO.getName());
        List<User> users = groupDTO.getUsers().stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList());
        group.setUsers(users);

        return group;
    }
}

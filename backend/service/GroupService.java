package com.fitrack.demo.service;

import com.fitrack.demo.DTO.GroupDTO;
import com.fitrack.demo.Mapper.GroupMapper;
import com.fitrack.demo.Mapper.UserMapper;
import com.fitrack.demo.model.Group;
import com.fitrack.demo.model.User;
import com.fitrack.demo.repository.GroupRepository;
import com.fitrack.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private UserMapper userMapper;

    public GroupDTO createGroup(String name) {
        Group group = new Group();
        group.setName(name);
        return groupMapper.toDTO(groupRepository.save(group));
    }

    public GroupDTO joinGroup(Long groupId, Long userId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        group.getUsers().add(user);
        return groupMapper.toDTO(groupRepository.save(group));
    }

    public List<GroupDTO> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(groupMapper::toDTO)
                .collect(Collectors.toList());
    }
}

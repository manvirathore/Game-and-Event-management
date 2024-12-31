package com.fitrack.demo.controller;

import com.fitrack.demo.DTO.GroupDTO;
import com.fitrack.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDTO> createGroup(@RequestParam String name) {
        return new ResponseEntity<>(groupService.createGroup(name), HttpStatus.CREATED);
    }

    @PostMapping("/{groupId}/join")
    public ResponseEntity<GroupDTO> joinGroup(@PathVariable Long groupId, @RequestParam Long userId) {
        return new ResponseEntity<>(groupService.joinGroup(groupId, userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        return new ResponseEntity<>(groupService.getAllGroups(), HttpStatus.OK);
    }
}

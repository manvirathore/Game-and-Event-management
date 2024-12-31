package com.fitrack.demo.controller;

import com.fitrack.demo.DTO.TeamDTO;
import com.fitrack.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO) {
        return new ResponseEntity<>(teamService.createTeam(teamDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
    }

    @GetMapping("/countByUserId/{userId}")
    public ResponseEntity<Long> countTeamsByUserId(@PathVariable Long userId) {
        long count = teamService.countTeamsByUserId(userId);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}


//}
//package com.fitrack.demo.controller;
//
//import com.fitrack.demo.DTO.TeamDTO;
//import com.fitrack.demo.service.TeamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/teams")
//@CrossOrigin(origins = "http://localhost:4200")
//public class TeamController {
//
//    @Autowired
//    private TeamService teamService;
//
//    @PostMapping
//    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO) {
//        return new ResponseEntity<>(teamService.createTeam(teamDTO), HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<TeamDTO>> getAllTeams() {
//        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
//    }
//
//    @GetMapping("/countByUserId/{userId}")
//    public ResponseEntity<Long> countTeamsByUserId(@PathVariable Long userId) {
//        long count = teamService.countTeamsByUserId(userId);
//        return new ResponseEntity<>(count, HttpStatus.OK);
//    }
//}

//package com.fitrack.demo.controller;
//
//import com.fitrack.demo.DTO.TeamDTO;
//import com.fitrack.demo.service.TeamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/teams")
//@CrossOrigin(origins = "http://localhost:4200")
//public class TeamController {
//
//    @Autowired
//    private TeamService teamService;
//
//    @PostMapping
//    public ResponseEntity<?> createTeam(@RequestBody TeamDTO teamDTO) {
//        try {
//            if (teamDTO.getUserIds() == null || teamDTO.getUserIds().isEmpty()) {
//                return new ResponseEntity<>("User IDs cannot be null or empty", HttpStatus.BAD_REQUEST);
//            }
//            TeamDTO createdTeam = teamService.createTeam(teamDTO);
//            return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
//        } catch (RuntimeException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping
//    public ResponseEntity<List<TeamDTO>> getAllTeams() {
//        return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
//    }
//
//    @GetMapping("/countByUserId/{userId}")
//    public ResponseEntity<Long> countTeamsByUserId(@PathVariable Long userId) {
//        long count = teamService.countTeamsByUserId(userId);
//        return new ResponseEntity<>(count, HttpStatus.OK);
//    }
//}


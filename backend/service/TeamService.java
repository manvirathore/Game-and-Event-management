package com.fitrack.demo.service;

import com.fitrack.demo.DTO.TeamDTO;
import com.fitrack.demo.Mapper.TeamMapper;
import com.fitrack.demo.model.Team;
import com.fitrack.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    public TeamDTO createTeam(TeamDTO teamDTO) {
        if (teamDTO.getUserIds().size() > 10) {
            throw new IllegalArgumentException("A team can have a maximum of 10 users.");
        }
        Team team = teamMapper.toEntity(teamDTO);
        return teamMapper.toDTO(teamRepository.save(team));
    }

    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }

    public long countTeamsByUserId(Long userId) {
        return teamRepository.countTeamsByUserId(userId);
    }
}

//package com.fitrack.demo.service;
//
//import com.fitrack.demo.DTO.TeamDTO;
//import com.fitrack.demo.Mapper.TeamMapper;
//import com.fitrack.demo.model.Team;
//import com.fitrack.demo.repository.TeamRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class TeamService {
//
//    @Autowired
//    private TeamRepository teamRepository;
//
//    @Autowired
//    private TeamMapper teamMapper;
//
//    public TeamDTO createTeam(TeamDTO teamDTO) {
//        if (teamDTO.getUserIds().size() > 10) {
//            throw new IllegalArgumentException("A team can have a maximum of 10 users.");
//        }
//        Team team = teamMapper.toEntity(teamDTO);
//        return teamMapper.toDTO(teamRepository.save(team));
//    }
//
//    public List<TeamDTO> getAllTeams() {
//        return teamRepository.findAll().stream()
//                .map(teamMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    public long countTeamsByUserId(Long userId) {
//        return teamRepository.countTeamsByUserId(userId);
//    }
//}


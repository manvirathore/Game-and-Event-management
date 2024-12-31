//package com.fitrack.demo.Mapper;
//
//import com.fitrack.demo.DTO.TeamDTO;
//import com.fitrack.demo.model.Team;
//import com.fitrack.demo.model.User;
//import com.fitrack.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class TeamMapper {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public TeamDTO toDTO(Team team) {
//        if (team == null) {
//            return null;
//        }
//
//        TeamDTO teamDTO = new TeamDTO();
//        teamDTO.setId(team.getId());
//        teamDTO.setName(team.getName());
//        teamDTO.setEventId(team.getEventId());
//        teamDTO.setUserIds(team.getUsers().stream()
//                .map(User::getId)
//                .collect(Collectors.toList()));
//
//        return teamDTO;
//    }
//
//    public Team toEntity(TeamDTO teamDTO) {
//        if (teamDTO == null) {
//            return null;
//        }
//
//        Team team = new Team();
//        team.setId(teamDTO.getId());
//        team.setName(teamDTO.getName());
//        team.setEventId(teamDTO.getEventId());
//        team.setUsers(teamDTO.getUserIds().stream()
//                .map(userId -> userRepository.findById(userId)
//                        .orElseThrow(() -> new RuntimeException("User not found")))
//                .collect(Collectors.toList()));
//
//        return team;
//    }
//}

package com.fitrack.demo.Mapper;

import com.fitrack.demo.DTO.TeamDTO;
import com.fitrack.demo.model.Team;
import com.fitrack.demo.model.User;
import com.fitrack.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamMapper {

    @Autowired
    private UserRepository userRepository;

    public TeamDTO toDTO(Team team) {
        if (team == null) {
            return null;
        }

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setEventId(team.getEventId());
        teamDTO.setUserIds(team.getUsers().stream()
                .map(User::getId)
                .collect(Collectors.toList()));

        return teamDTO;
    }

    public Team toEntity(TeamDTO teamDTO) {
        if (teamDTO == null) {
            return null;
        }

        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        team.setEventId(teamDTO.getEventId());

        List<Long> userIds = teamDTO.getUserIds();
        if (userIds != null && !userIds.isEmpty()) {
            team.setUsers(userIds.stream()
                    .map(userId -> userRepository.findById(userId)
                            .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId)))
                    .collect(Collectors.toList()));
        }

        return team;
    }
}


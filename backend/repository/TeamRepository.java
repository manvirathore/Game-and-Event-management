package com.fitrack.demo.repository;

import com.fitrack.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT COUNT(t) FROM Team t JOIN t.users u WHERE u.id = :userId")
    long countTeamsByUserId(@Param("userId") Long userId);
}

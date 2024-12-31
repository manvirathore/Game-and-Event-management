package com.fitrack.demo.repository;

import com.fitrack.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByNameContainingIgnoreCase(String keyword);
    List<Event> findByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}

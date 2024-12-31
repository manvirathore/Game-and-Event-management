package com.fitrack.demo.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String eventName;

    @NotNull
    private String venue;

    @NotNull
    private LocalDateTime time;

    @NotNull
    private Double duration; // Duration in hours

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Double getDuration() {
        return duration;
    }

    public void setDuration(@NotNull Double duration) {
        this.duration = duration;
    }

    public @NotNull LocalDateTime getTime() {
        return time;
    }

    public void setTime(@NotNull LocalDateTime time) {
        this.time = time;
    }

    public @NotNull String getVenue() {
        return venue;
    }

    public void setVenue(@NotNull String venue) {
        this.venue = venue;
    }

    public @NotNull String getEventName() {
        return eventName;
    }

    public void setEventName(@NotNull String eventName) {
        this.eventName = eventName;
    }
}


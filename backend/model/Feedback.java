package com.fitrack.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "feedback")
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long eventId;

    @NotNull
    private String feedback;

    // Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setFeedback(@NotNull String feedback) {
        this.feedback = feedback;
    }

    public void setEventId(@NotNull Long eventId) {
        this.eventId = eventId;
    }

    public @NotNull String getFeedback() {
        return feedback;
    }

    public @NotNull Long getEventId() {
        return eventId;
    }

    public Long getId() {
        return id;
    }
}

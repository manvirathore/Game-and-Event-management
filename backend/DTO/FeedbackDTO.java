package com.fitrack.demo.DTO;

public class FeedbackDTO {

    private Long id;
    private Long eventId;
    private String feedback;

    public Long getEventId() {
        return eventId;
    }

    public Long getId() {
        return id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setId(Long id) {
        this.id = id;
    }
// Getters and Setters
}

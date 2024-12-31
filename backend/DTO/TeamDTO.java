package com.fitrack.demo.DTO;

import java.util.List;

public class TeamDTO {

    private Long id;
    private String name;
    private Long eventId;
    private List<Long> userIds;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setName(String name) {
        this.name = name;
    }
}


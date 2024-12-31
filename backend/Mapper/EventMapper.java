package com.fitrack.demo.Mapper;

import com.fitrack.demo.DTO.EventDTO;
import com.fitrack.demo.model.Event;
import com.fitrack.demo.model.Venue;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventDTO toDTO(Event event) {
        if (event == null) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setDateTime(event.getDateTime());
        eventDTO.setVenueId(event.getVenue().getId());

        return eventDTO;
    }

    public Event toEntity(EventDTO eventDTO, Venue venue) {
        if (eventDTO == null) {
            return null;
        }

        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setDateTime(eventDTO.getDateTime());
        event.setVenue(venue);

        return event;
    }

    public Event toEntity(EventDTO eventDTO) {
        if (eventDTO == null) {
            return null;
        }
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setDateTime(eventDTO.getDateTime());

        return event;
    }
}


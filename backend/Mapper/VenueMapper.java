package com.fitrack.demo.Mapper;

import com.fitrack.demo.DTO.VenueDTO;
import com.fitrack.demo.DTO.EventDTO;
import com.fitrack.demo.model.Event;
import com.fitrack.demo.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VenueMapper {

    @Autowired
    private EventMapper eventMapper;

    public VenueDTO toDTO(Venue venue) {
        if (venue == null) {
            return null;
        }

        VenueDTO venueDTO = new VenueDTO();
        venueDTO.setId(venue.getId());
        venueDTO.setName(venue.getName());
        venueDTO.setAddress(venue.getAddress());
        List<EventDTO> eventDTOs = venue.getEvents().stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
        venueDTO.setEvents(eventDTOs);

        return venueDTO;
    }

    public Venue toEntity(VenueDTO venueDTO) {
        if (venueDTO == null) {
            return null;
        }

        Venue venue = new Venue();
        venue.setId(venueDTO.getId());
        venue.setName(venueDTO.getName());
        venue.setAddress(venueDTO.getAddress());
        List<Event> events = venueDTO.getEvents().stream()
                .map(eventDTO -> eventMapper.toEntity(eventDTO, venue))
                .collect(Collectors.toList());
        venue.setEvents(events);

        return venue;
    }
}

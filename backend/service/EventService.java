package com.fitrack.demo.service;

import com.fitrack.demo.DTO.EventDTO;
import com.fitrack.demo.exception.ResourceNotFoundException;
import com.fitrack.demo.Mapper.EventMapper;
import com.fitrack.demo.model.Event;
import com.fitrack.demo.model.Venue;
import com.fitrack.demo.repository.EventRepository;
import com.fitrack.demo.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private EventMapper eventMapper;

    public EventDTO createEvent(EventDTO eventDTO) {
        Venue venue = venueRepository.findById(eventDTO.getVenueId())
                .orElseThrow(() -> new RuntimeException("Venue not found"));
        Event event = eventMapper.toEntity(eventDTO);
        event.setVenue(venue);
        return eventMapper.toDTO(eventRepository.save(event));
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        Venue venue = venueRepository.findById(eventDTO.getVenueId())
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setDateTime(eventDTO.getDateTime());
        event.setVenue(venue);
        return eventMapper.toDTO(eventRepository.save(event));
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        eventRepository.delete(event);
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        return eventMapper.toDTO(event);
    }

    public List<EventDTO> searchEvents(String keyword) {
        return eventRepository.findByNameContainingIgnoreCase(keyword).stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EventDTO> filterEventsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return eventRepository.findByDateTimeBetween(startDate, endDate).stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }
}

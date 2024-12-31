package com.fitrack.demo.controller;

import com.fitrack.demo.DTO.EventDTO;
import com.fitrack.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping
    public ResponseEntity<EventDTO> createEvent( @RequestBody EventDTO eventDTO) {
        return new ResponseEntity<>(eventService.createEvent(eventDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id,  @RequestBody EventDTO eventDTO) {
        return new ResponseEntity<>(eventService.updateEvent(id, eventDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.getEventById(id), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<EventDTO>> searchEvents(@RequestParam String keyword) {
        return new ResponseEntity<>(eventService.searchEvents(keyword), HttpStatus.OK);
    }

    @GetMapping("/filter")
//    public ResponseEntity<List<EventDTO>> filterEventsByDateRange(
//            @RequestParam LocalDateTime startDate,
//            @RequestParam LocalDateTime endDate) {
//        return new ResponseEntity<>(eventService.filterEventsByDateRange(startDate, endDate), HttpStatus.OK);
//    }
    public ResponseEntity<List<EventDTO>> filterEventsByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return new ResponseEntity<>(eventService.filterEventsByDateRange(startDate, endDate), HttpStatus.OK);
    }
}

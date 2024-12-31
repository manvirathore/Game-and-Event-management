package com.fitrack.demo.controller;

import com.fitrack.demo.DTO.VenueDTO;
import com.fitrack.demo.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping
    public ResponseEntity<VenueDTO> createVenue( @RequestBody VenueDTO venueDTO) {
        return new ResponseEntity<>(venueService.createVenue(venueDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenueDTO> updateVenue(@PathVariable Long id,  @RequestBody VenueDTO venueDTO) {
        return new ResponseEntity<>(venueService.updateVenue(id, venueDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<VenueDTO>> getAllVenues() {
        return new ResponseEntity<>(venueService.getAllVenues(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueDTO> getVenueById(@PathVariable Long id) {
        return new ResponseEntity<>(venueService.getVenueById(id), HttpStatus.OK);
    }
}

package com.fitrack.demo.service;

import com.fitrack.demo.DTO.VenueDTO;
import com.fitrack.demo.exception.ResourceNotFoundException;
import com.fitrack.demo.Mapper.VenueMapper;
import com.fitrack.demo.model.Venue;
import com.fitrack.demo.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private VenueMapper venueMapper;

    public VenueDTO createVenue(VenueDTO venueDTO) {
        Venue venue = venueMapper.toEntity(venueDTO);
        return venueMapper.toDTO(venueRepository.save(venue));
    }

    public VenueDTO updateVenue(Long id, VenueDTO venueDTO) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
        venue.setName(venueDTO.getName());
        venue.setAddress(venueDTO.getAddress());
        return venueMapper.toDTO(venueRepository.save(venue));
    }

    public void deleteVenue(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
        venueRepository.delete(venue);
    }

    public List<VenueDTO> getAllVenues() {
        return venueRepository.findAll().stream()
                .map(venueMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VenueDTO getVenueById(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found"));
        return venueMapper.toDTO(venue);
    }
}

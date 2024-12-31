package com.fitrack.demo.service;

import com.fitrack.demo.DTO.BookingDTO;
import com.fitrack.demo.Mapper.BookingMapper;
import com.fitrack.demo.model.Booking;
import com.fitrack.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        return bookingMapper.toDTO(bookingRepository.save(booking));
    }
}

package com.fitrack.demo.Mapper;

import com.fitrack.demo.DTO.BookingDTO;
import com.fitrack.demo.model.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingDTO toDTO(Booking booking) {
        if (booking == null) {
            return null;
        }

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setEventName(booking.getEventName());
        bookingDTO.setVenue(booking.getVenue());
        bookingDTO.setTime(booking.getTime());
        bookingDTO.setDuration(booking.getDuration());

        return bookingDTO;
    }

    public Booking toEntity(BookingDTO bookingDTO) {
        if (bookingDTO == null) {
            return null;
        }

        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setEventName(bookingDTO.getEventName());
        booking.setVenue(bookingDTO.getVenue());
        booking.setTime(bookingDTO.getTime());
        booking.setDuration(bookingDTO.getDuration());

        return booking;
    }
}


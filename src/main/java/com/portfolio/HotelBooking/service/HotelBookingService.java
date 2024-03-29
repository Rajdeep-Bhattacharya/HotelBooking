package com.portfolio.HotelBooking.service;

import com.portfolio.HotelBooking.models.Hotel;
import com.portfolio.HotelBooking.models.HotelBooking;
import com.portfolio.HotelBooking.repository.HotelBookingCacheRepository;
import com.portfolio.HotelBooking.repository.HotelBookingRepository;
import com.portfolio.HotelBooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelBookingService {

    @Autowired
    private HotelBookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository; // Assuming you have a HotelRepository
    @Autowired
    private HotelBookingCacheRepository cacheRepository;
    // Fetch bookings by hotel ID
    public List<HotelBooking> getBookingsByHotel(Long hotelId) {
        return bookingRepository.findByHotelId(hotelId);
    }

    // Create or update a booking with hotel ID
    public HotelBooking saveBooking(Long hotelId, HotelBooking booking) {
        // Find the hotel by ID
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));

        // Set the hotel to the booking
        booking.setHotel(hotel);

        // Save the booking
        return bookingRepository.save(booking);
    }


    public HotelBooking createBooking(HotelBooking booking) {
        // Optionally add caching logic here
        return bookingRepository.save(booking);
    }

    public Optional<HotelBooking> getBookingById(Long id) {
        // Check cache first, then fall back to SQL DB
        return Optional.ofNullable(cacheRepository.findById(id)
                .orElseGet(() -> bookingRepository.findById(id).orElse(null)));
    }
}
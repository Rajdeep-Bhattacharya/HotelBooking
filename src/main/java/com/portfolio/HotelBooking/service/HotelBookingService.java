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
    private HotelRepository hotelRepository;
    @Autowired
    private HotelBookingCacheRepository cacheRepository;


    @Autowired
    public HotelBookingService(HotelBookingCacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    public List<HotelBooking> getBookingsByHotel(Long hotelId) {
        return bookingRepository.findByHotel_Id(hotelId);
    }

    public HotelBooking saveBooking(Long hotelId, HotelBooking booking) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + hotelId));
        booking.setHotel(hotel);
        return bookingRepository.save(booking);
    }


    public HotelBooking createBooking(HotelBooking booking) {
        if (booking.getHotelId() != null) {
            Hotel hotel = hotelRepository.findById(booking.getHotelId())
                    .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + booking.getHotelId()));
            booking.setHotel(hotel);
        } else {
            throw new RuntimeException("Hotel ID must be provided");
        }

        HotelBooking savedBooking = bookingRepository.save(booking);
        cacheRepository.save(savedBooking); // Assuming this method is correctly implemented
        return savedBooking;
    }

    public Optional<HotelBooking> getBookingById(Long id) {
        return Optional.ofNullable(cacheRepository.findById(id)
                .orElseGet(() -> bookingRepository.findById(id).orElse(null)));
    }
}
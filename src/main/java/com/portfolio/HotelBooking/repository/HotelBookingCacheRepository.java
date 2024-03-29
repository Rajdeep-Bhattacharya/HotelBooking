package com.portfolio.HotelBooking.repository;

import com.portfolio.HotelBooking.models.HotelBooking;

import java.util.Optional;

public interface HotelBookingCacheRepository {
    void save(HotelBooking booking);

    Optional<HotelBooking> findById(Long id);

    void deleteById(Long id);
    // Add more methods as needed
}

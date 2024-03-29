package com.portfolio.HotelBooking.repository;

import com.portfolio.HotelBooking.models.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {

    List<HotelBooking> findByHotelId(Long hotelId);
}


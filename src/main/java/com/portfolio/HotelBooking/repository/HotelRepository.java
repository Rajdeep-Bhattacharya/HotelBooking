package com.portfolio.HotelBooking.repository;

import com.portfolio.HotelBooking.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // You can define custom query methods here if needed
}
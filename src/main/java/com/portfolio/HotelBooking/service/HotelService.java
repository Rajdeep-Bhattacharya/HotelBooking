package com.portfolio.HotelBooking.service;

import com.portfolio.HotelBooking.models.Hotel;
import com.portfolio.HotelBooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> getHotelById(Long id) {
        return Optional.ofNullable(hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found for id: " + id)));
    }
}

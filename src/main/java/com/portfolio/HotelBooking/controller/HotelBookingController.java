package com.portfolio.HotelBooking.controller;

import com.portfolio.HotelBooking.models.HotelBooking;
import com.portfolio.HotelBooking.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/bookings")
public class HotelBookingController {

    @Autowired
    private HotelBookingService bookingService;

    @PostMapping
    public HotelBooking createBooking(@RequestBody HotelBooking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{id}")
    public HotelBooking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


}

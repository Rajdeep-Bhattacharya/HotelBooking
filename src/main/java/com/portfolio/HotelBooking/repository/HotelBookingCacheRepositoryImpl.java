package com.portfolio.HotelBooking.repository;

import com.portfolio.HotelBooking.models.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HotelBookingCacheRepositoryImpl implements HotelBookingCacheRepository {

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations; // to access Redis cache

    private static final String KEY = "HotelBooking";

    @Autowired
    public HotelBookingCacheRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(HotelBooking booking) {
        hashOperations.put(KEY, booking.getId().toString(), booking);
    }

    @Override
    public Optional<HotelBooking> findById(Long id) {
        return Optional.ofNullable((HotelBooking) hashOperations.get(KEY, id.toString()));
    }

    @Override
    public void deleteById(Long id) {
        hashOperations.delete(KEY, id.toString());
    }

    // Implement additional methods as needed
}

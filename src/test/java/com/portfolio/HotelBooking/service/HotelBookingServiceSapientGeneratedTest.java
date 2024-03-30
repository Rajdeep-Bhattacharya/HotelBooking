package com.portfolio.HotelBooking.service;

import org.junit.jupiter.api.Timeout;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import com.portfolio.HotelBooking.models.HotelBooking;
import org.mockito.MockitoAnnotations;
import com.portfolio.HotelBooking.repository.HotelRepository;
import com.portfolio.HotelBooking.repository.HotelBookingRepository;

import java.util.ArrayList;

import com.portfolio.HotelBooking.repository.HotelBookingCacheRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doReturn;

@Timeout(value = 5, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
class HotelBookingServiceSapientGeneratedTest {

    private final HotelBookingRepository bookingRepositoryMock = mock(HotelBookingRepository.class, "bookingRepository");

    private final HotelRepository hotelRepositoryMock = mock(HotelRepository.class, "hotelRepository");

    private final HotelBookingCacheRepository cacheRepositoryMock = mock(HotelBookingCacheRepository.class, "cacheRepository");

    private AutoCloseable autoCloseableMocks;

    @InjectMocks()
    private HotelBookingService target;

    @AfterEach()
    public void afterTest() throws Exception {
        if (autoCloseableMocks != null)
            autoCloseableMocks.close();
    }

    //Sapient generated method id: ${52f5f7cd-f046-3841-8fa7-fe6600d2afde}
    @Test()
    void getBookingsByHotelTest() {
        //Arrange Statement(s)
        HotelBookingCacheRepository hotelBookingCacheRepositoryMock = mock(HotelBookingCacheRepository.class);
        target = new HotelBookingService(hotelBookingCacheRepositoryMock);
        autoCloseableMocks = MockitoAnnotations.openMocks(this);
        List<HotelBooking> hotelBookingList = new ArrayList<>();
        doReturn(hotelBookingList).when(bookingRepositoryMock).findByHotel_Id(0L);

        //Act Statement(s)
        List<HotelBooking> result = target.getBookingsByHotel(0L);

        //Assert statement(s)
        assertAll("result", () -> {
            assertThat(result, equalTo(hotelBookingList));
            verify(bookingRepositoryMock).findByHotel_Id(0L);
        });
    }
}

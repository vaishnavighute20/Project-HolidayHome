package com.hotelbooking.services;
import java.util.List;

import com.hotelbooking.entity.Booking;
public interface IBookingService {
List<Booking> getAllBookings();
Booking getBookingById(Long id);
Booking saveBooking(Booking booking);
void deleteBooking(Long id);
}

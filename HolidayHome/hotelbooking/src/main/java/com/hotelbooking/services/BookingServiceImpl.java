package com.hotelbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.repo.IBookingRepo;

@Service
public class BookingServiceImpl implements IBookingService {

	 @Autowired
	    private IBookingRepo bookingRepository;

	    public List<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }

	    public Booking getBookingById(Long id) {
	        return bookingRepository.findById(id).orElse(null);
	    }

	    public Booking saveBooking(Booking booking) {
	        return bookingRepository.save(booking);
	    }

	    public void deleteBooking(Long id) {
	        bookingRepository.deleteById(id);
	    }

}

package com.hotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.Booking;

public interface IBookingRepo extends JpaRepository<Booking, Long>{

}

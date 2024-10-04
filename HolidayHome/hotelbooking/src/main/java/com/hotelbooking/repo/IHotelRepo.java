package com.hotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.Hotel;

public interface IHotelRepo extends JpaRepository<Hotel, Long> {

}

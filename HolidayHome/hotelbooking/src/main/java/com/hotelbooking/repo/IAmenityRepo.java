package com.hotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.Amenity;

public interface IAmenityRepo extends JpaRepository<Amenity, Long> {

}

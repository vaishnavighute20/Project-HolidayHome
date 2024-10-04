package com.hotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.RoomType;

public interface IRoomTypeRepo extends JpaRepository<RoomType, Long> {

}

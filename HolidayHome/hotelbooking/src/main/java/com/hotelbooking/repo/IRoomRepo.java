package com.hotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.Room;

public interface IRoomRepo extends JpaRepository<Room, Long> {
}

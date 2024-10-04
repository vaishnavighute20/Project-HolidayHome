package com.hotelbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Room;
import com.hotelbooking.repo.IRoomRepo;

@Service
public class RoomImpl implements IRoomService {

	 @Autowired
	    private IRoomRepo roomRepository;

	    public List<Room> getAllRooms() {
	        return roomRepository.findAll();
	    }

	    public Room getRoomById(Long id) {
	        return roomRepository.findById(id).orElse(null);
	    }

	    public Room saveRoom(Room room) {
	        return roomRepository.save(room);
	    }

	    public void deleteRoom(Long id) {
	        roomRepository.deleteById(id);
	    }

}

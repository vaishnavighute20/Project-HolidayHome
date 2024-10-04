package com.hotelbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.RoomType;
import com.hotelbooking.repo.IRoomTypeRepo;

@Service
public class RoomTypeImpl implements IRoomTypeService {

	 @Autowired
	    private IRoomTypeRepo roomTypeRepository;

	    public List<RoomType> getAllRoomTypes() {
	        return roomTypeRepository.findAll();
	    }

	    public RoomType getRoomTypeById(Long id) {
	        return roomTypeRepository.findById(id).orElse(null);
	    }

	    public RoomType saveRoomType(RoomType roomType) {
	        return roomTypeRepository.save(roomType);
	    }

	    public void deleteRoomType(Long id) {
	        roomTypeRepository.deleteById(id);
	    }

}

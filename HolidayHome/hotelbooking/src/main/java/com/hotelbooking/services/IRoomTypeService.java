package com.hotelbooking.services;
import java.util.List;

import com.hotelbooking.entity.RoomType;
public interface IRoomTypeService {
	List<RoomType> getAllRoomTypes();
	RoomType getRoomTypeById(Long id);
	RoomType saveRoomType(RoomType roomType);
	void deleteRoomType(Long id);
}

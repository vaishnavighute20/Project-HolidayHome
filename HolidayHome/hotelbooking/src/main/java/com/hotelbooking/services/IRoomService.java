package com.hotelbooking.services;
import java.util.List;

import com.hotelbooking.entity.Room;
public interface IRoomService {
List<Room> getAllRooms();
Room getRoomById(Long id);
Room saveRoom(Room room);
void deleteRoom(Long id);
}

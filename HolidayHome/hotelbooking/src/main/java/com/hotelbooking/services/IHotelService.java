package com.hotelbooking.services;
import java.util.List;

import com.hotelbooking.entity.Hotel;
public interface IHotelService {
List<Hotel> getAllHotels();
Hotel getHotelById(Long id);
Hotel saveHotel(Hotel hotel);
void deleteHotel(Long id);
}

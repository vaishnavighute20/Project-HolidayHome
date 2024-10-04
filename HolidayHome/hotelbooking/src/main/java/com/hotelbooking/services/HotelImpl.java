package com.hotelbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.repo.IHotelRepo;

@Service
public class HotelImpl implements IHotelService {
@Autowired
private IHotelRepo hotelrepo;
	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelrepo.findAll();
	}

	@Override
	public Hotel getHotelById(Long id) {
		// TODO Auto-generated method stub
		return hotelrepo.findById(id).orElse(null);
	}

	@Override
	public Hotel saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelrepo.save(hotel);
	}

	@Override
	public void deleteHotel(Long id) {
		hotelrepo.deleteById(id);

	}

}

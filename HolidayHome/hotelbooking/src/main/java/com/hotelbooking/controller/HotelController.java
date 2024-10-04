package com.hotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.services.IHotelService;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin
public class HotelController {

	@Autowired
	private IHotelService hotelService;

	@GetMapping
	public ResponseEntity<?> getAllHotels() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
		Hotel hotel = hotelService.getHotelById(id);
		if (hotel != null) {
			return ResponseEntity.ok(hotel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails) {
		Hotel hotel = hotelService.getHotelById(id);
		if (hotel != null) {
			hotel.setName(hotelDetails.getName());
			hotel.setAddress(hotelDetails.getAddress());
			hotel.setCity(hotelDetails.getCity());
			hotel.setState(hotelDetails.getState());
			hotel.setCountry(hotelDetails.getCountry());
			hotel.setZipCode(hotelDetails.getZipCode());
			hotel.setRooms(hotelDetails.getRooms());
			hotel.setBookings(hotelDetails.getBookings());
			return ResponseEntity.ok(hotelService.saveHotel(hotel));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
		hotelService.deleteHotel(id);
		return ResponseEntity.noContent().build();
	}
}

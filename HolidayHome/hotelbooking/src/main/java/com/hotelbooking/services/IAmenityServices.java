package com.hotelbooking.services;
import java.util.List;

import com.hotelbooking.entity.Amenity;
public interface IAmenityServices {
	 public void deleteAmenity(Long id);
	 public Amenity saveAmenity(Amenity amenity);
	 public Amenity getAmenityById(Long id);
	 public List<Amenity> getAllAmenities();
}

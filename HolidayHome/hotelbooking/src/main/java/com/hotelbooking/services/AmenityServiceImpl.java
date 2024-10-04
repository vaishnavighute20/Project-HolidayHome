package com.hotelbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Amenity;
import com.hotelbooking.repo.IAmenityRepo;

@Service
public class AmenityServiceImpl implements IAmenityServices {

	 @Autowired
	    private IAmenityRepo amenityRepository;

	    public List<Amenity> getAllAmenities() {
	        return amenityRepository.findAll();
	    }

	    public Amenity getAmenityById(Long id) {
	        return amenityRepository.findById(id).orElse(null);
	    }

	    public Amenity saveAmenity(Amenity amenity) {
	        return amenityRepository.save(amenity);
	    }

	    public void deleteAmenity(Long id) {
	        amenityRepository.deleteById(id);
	    }
}

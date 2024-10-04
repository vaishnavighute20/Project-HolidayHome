package com.hotelbooking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Review;
import com.hotelbooking.repo.IReviewRepo;

@Service
public class ReviewServiceImpl implements IReviewService {

	 @Autowired
	    private IReviewRepo reviewRepository;

	    public List<Review> getAllReviews() {
	        return reviewRepository.findAll();
	    }

	    public Review getReviewById(Long id) {
	        return reviewRepository.findById(id).orElse(null);
	    }

	    public Review saveReview(Review review) {
	        return reviewRepository.save(review);
	    }

	    public void deleteReview(Long id) {
	        reviewRepository.deleteById(id);
	    }

}

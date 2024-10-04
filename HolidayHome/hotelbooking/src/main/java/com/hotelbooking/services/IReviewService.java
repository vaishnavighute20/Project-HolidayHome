package com.hotelbooking.services;
import java.util.List;

import com.hotelbooking.entity.Review;
public interface IReviewService {
List<Review> getAllReviews();
Review getReviewById(Long id);
Review saveReview(Review review);
void deleteReview(Long id);
}

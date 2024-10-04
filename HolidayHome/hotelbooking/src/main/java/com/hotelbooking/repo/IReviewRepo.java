package com.hotelbooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.Review;

public interface IReviewRepo extends JpaRepository<Review, Long>{

}

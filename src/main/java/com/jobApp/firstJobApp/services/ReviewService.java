package com.jobApp.firstJobApp.services;

import com.jobApp.firstJobApp.entities.Company;
import com.jobApp.firstJobApp.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review);
}

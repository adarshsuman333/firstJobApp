package com.jobApp.firstJobApp.services;

import com.jobApp.firstJobApp.entities.Review;
import com.jobApp.firstJobApp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
         List<Review> reviews = reviewRepository.findByCompanyId(companyId);
         return reviews;
    }
}

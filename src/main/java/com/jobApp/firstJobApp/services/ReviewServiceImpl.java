package com.jobApp.firstJobApp.services;

import com.jobApp.firstJobApp.entities.Company;
import com.jobApp.firstJobApp.entities.Review;
import com.jobApp.firstJobApp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private CompanyService companyService;

//    public ReviewServiceImpl(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }

    public ReviewServiceImpl(CompanyService companyService, ReviewRepository reviewRepository) {
        this.companyService = companyService;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }
}

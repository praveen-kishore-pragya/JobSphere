package com.praveen.JobSphere.review.service;

import com.praveen.JobSphere.review.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsOfCompany(Long companyId);

    Review getSpecificReviewOfCompanyById(Long companyId, Long reviewId);

    boolean createNewReviewOfCompany(Long companyId, Review newReview);

    boolean updateReviewOfCompanyById(Long companyId, Long reviewId, Review updatedReview);

    boolean deleteReviewOfCompanyById(Long companyId, Long reviewId);
}

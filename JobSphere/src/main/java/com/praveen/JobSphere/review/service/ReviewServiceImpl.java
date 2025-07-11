package com.praveen.JobSphere.review.service;

import com.praveen.JobSphere.company.entity.Company;
import com.praveen.JobSphere.company.repository.CompanyRepository;
import com.praveen.JobSphere.review.entity.Review;
import com.praveen.JobSphere.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Review> getAllReviewsOfCompany(Long companyId) {
        List<Review> allReviewsInDB = reviewRepository.findAll();
        List<Review> reviewsOfCompany = new ArrayList<>();
        for(Review reviewIterator : allReviewsInDB){
            if(reviewIterator.getCompany().getId().equals(companyId)){
                reviewsOfCompany.add(reviewIterator);
            }
        }

        return reviewsOfCompany;
    }

    @Override
    public Review getSpecificReviewOfCompanyById(Long companyId, Long reviewId) {
        List<Review> allReviewsInDB = reviewRepository.findAll();
        List<Review> reviewsOfCompany = new ArrayList<>();
        for(Review reviewIterator : allReviewsInDB){
            if(reviewIterator.getCompany().getId().equals(companyId)){
                reviewsOfCompany.add(reviewIterator);
            }
        }

        for(Review requiredReview : reviewsOfCompany){
            if(requiredReview.getId().equals(reviewId)){
                return requiredReview;
            }
        }

        return null;
    }

    @Override
    public boolean createNewReviewOfCompany(Long companyId, Review newReview) {
        Company fetchedCompany = companyRepository.findById(companyId).orElse(null);
        if(fetchedCompany != null){
            newReview.setCompany(fetchedCompany);
            reviewRepository.save(newReview);
            return true;
        }

        return false;
    }

    @Override
    public boolean updateReviewOfCompanyById(Long companyId, Long reviewId, Review updatedReview) {
        List<Review> allReviewsInDB = reviewRepository.findAll();
        List<Review> reviewsOfCompany = new ArrayList<>();
        for(Review reviewIterator : allReviewsInDB){
            if(reviewIterator.getCompany().getId().equals(companyId)){
                reviewsOfCompany.add(reviewIterator);
            }
        }

        for(Review requiredReview : reviewsOfCompany){
            if(requiredReview.getId().equals(reviewId)){
                requiredReview.setDescription(updatedReview.getDescription());
                requiredReview.setCompany(updatedReview.getCompany());
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean deleteReviewOfCompanyById(Long companyId, Long reviewId) {
        List<Review> allReviewsInDB = reviewRepository.findAll();
        List<Review> reviewsOfCompany = new ArrayList<>();
        for(Review reviewIterator : allReviewsInDB){
            if(reviewIterator.getCompany().getId().equals(companyId)){
                reviewsOfCompany.add(reviewIterator);
            }
        }

        for(Review requiredReview : reviewsOfCompany){
            if(requiredReview.getId().equals(reviewId)){
                reviewRepository.delete(requiredReview);
            }
        }

        return false;
    }
}

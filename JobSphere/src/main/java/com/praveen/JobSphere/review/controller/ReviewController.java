package com.praveen.JobSphere.review.controller;

import com.praveen.JobSphere.review.entity.Review;
import com.praveen.JobSphere.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/companies/{companyId}/reviews")
    public ResponseEntity<?> getAllReviewsOfCompany(@PathVariable Long companyId){
        List<Review> allReviews = reviewService.getAllReviewsOfCompany(companyId);
        if(!allReviews.isEmpty()){
            return new ResponseEntity<>(allReviews, HttpStatus.OK);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<?> getSpecificReviewOfCompanyById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review fetchedReview = reviewService.getSpecificReviewOfCompanyById(companyId, reviewId);
        if(fetchedReview != null){
            return new ResponseEntity<>(fetchedReview, HttpStatus.OK);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/companies/{companyId}/reviews")
    public ResponseEntity<?> createNewReviewOfCompany(@PathVariable Long companyId, @RequestBody Review newReview){
        boolean isReviewCreated = reviewService.createNewReviewOfCompany(companyId, newReview);
        if(isReviewCreated){
            return new ResponseEntity<>("Record created!", HttpStatus.CREATED);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<?> updateReviewOfCompanyById(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review updatedReview){
        boolean isReviewUpdated = reviewService.updateReviewOfCompanyById(companyId, reviewId, updatedReview);
        if(isReviewUpdated){
            return new ResponseEntity<>("Record updated!", HttpStatus.CREATED);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/companies/{companyId}/reviews/{reviewId}")
    public ResponseEntity<?> deleteReviewOfCompanyById(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReviewOfCompanyById(companyId, reviewId);
        if(isReviewDeleted){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

}

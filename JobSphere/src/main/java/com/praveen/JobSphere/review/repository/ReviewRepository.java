package com.praveen.JobSphere.review.repository;

import com.praveen.JobSphere.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>{
}

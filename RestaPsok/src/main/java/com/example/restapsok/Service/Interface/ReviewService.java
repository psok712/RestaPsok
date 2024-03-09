package com.example.restapsok.Service.Interface;

import com.example.restapsok.Model.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    ResponseEntity<List<Review>> getAllReview();
    ResponseEntity<Review> getReviewById(Long id);
    ResponseEntity<String> createReview(Review review);
}

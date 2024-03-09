package com.example.restapsok.Service;

import com.example.restapsok.Model.Review;
import com.example.restapsok.Repository.OrderPositionRepository;
import com.example.restapsok.Repository.ReviewRepository;
import com.example.restapsok.Service.Interface.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviews;
    private final OrderPositionRepository orders;

    public ReviewServiceImpl(ReviewRepository reviewsRep, OrderPositionRepository ordersRep) {
        reviews = reviewsRep;
        orders = ordersRep;
    }

    public ResponseEntity<List<Review>> getAllReview() {
        return new ResponseEntity<>(reviews.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Review> getReviewById(Long id) {
        if (reviews.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reviews.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<String> createReview(Review review) {
        if (orders.findById(review.getOrderId()).isEmpty()) {
            return new ResponseEntity<>(
                    "Unfortunately, this order number does not exist!", HttpStatus.BAD_REQUEST);
        }

        if (review.getGrade() > 5) {
            review.setGrade(5);
        } else if (review.getGrade() < 0) {
            review.setGrade(0);
        }

        reviews.save(review);

        return new ResponseEntity<>("Review successfully saved!", HttpStatus.OK);
    }
}

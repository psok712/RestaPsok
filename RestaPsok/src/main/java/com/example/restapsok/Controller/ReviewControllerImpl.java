package com.example.restapsok.Controller;

import com.example.restapsok.Controller.Interface.ReviewController;
import com.example.restapsok.Model.Review;
import com.example.restapsok.Repository.OrderPositionRepository;
import com.example.restapsok.Repository.ReviewRepository;
import com.example.restapsok.Service.Interface.ReviewService;
import com.example.restapsok.Service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/review")
@RestController
public class ReviewControllerImpl implements ReviewController {

    @Autowired
    ReviewRepository reviews;
    @Autowired
    OrderPositionRepository orders;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReview() {
        ReviewService service = new ReviewServiceImpl(reviews, orders);
        return service.getAllReview();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        ReviewService service = new ReviewServiceImpl(reviews, orders);
        return service.getReviewById(id);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        ReviewService service = new ReviewServiceImpl(reviews, orders);
        return service.createReview(review);
    }
}

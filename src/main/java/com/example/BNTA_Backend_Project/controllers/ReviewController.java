package com.example.BNTA_Backend_Project.controllers;

import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Review>> getReviewById(@PathVariable Long id){
        return null;
    }

    //TODO check whether we need "List<Review>"
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review){
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable Long id){
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteReview(@PathVariable Long id){
        return null;
    }


}

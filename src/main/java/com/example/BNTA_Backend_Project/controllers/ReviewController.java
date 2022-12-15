package com.example.BNTA_Backend_Project.controllers;

import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewAndFilters(
            @RequestParam(required = false, name = "rating") Optional<Integer> rating,
            @RequestParam(required = false, name = "reviewBody") Optional<String> reviewBody,
            @RequestParam(required = false, name = "movieId") Optional<Long> movieId,
            @RequestParam(required = false, name = "movieTitle") Optional<String> movieTitle,
            @RequestParam(required = false, name = "userId") Optional<Long> userId,
            @RequestParam(required = false, name = "userName") Optional<String> userName
    ){
        if(rating.isPresent()){
            return new ResponseEntity<>(reviewService.findReviewByRating(rating.get()), HttpStatus.OK);
        }
        if(reviewBody.isPresent()){
            return new ResponseEntity<>(reviewService.findReviewByReviewBody(reviewBody.get()), HttpStatus.OK);
        }
        if(movieId.isPresent()){
            return new ResponseEntity<>(reviewService.findReviewByMovieId(movieId.get()), HttpStatus.OK);
        }
        if(movieTitle.isPresent()){
            return new ResponseEntity<>(reviewService.findReviewByMovieTitle(movieTitle.get()), HttpStatus.OK);
        }
        if(userId.isPresent()){
            return new ResponseEntity<>(reviewService.findReviewByUserId(userId.get()), HttpStatus.OK);
        }
        if(userName.isPresent()){
            return new ResponseEntity<>(reviewService.findReviewByUserName(userName.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Review>> getMovieById(@PathVariable Long id){
        return new ResponseEntity(reviewService.getReviewById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(
            @RequestBody Review review){
        reviewService.addReview(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @PatchMapping (value = "/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable Long id){
        var updated = reviewService.updateReview(review, id);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
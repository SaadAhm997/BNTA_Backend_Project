package com.example.BNTA_Backend_Project.controllers;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.models.User;
import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import com.example.BNTA_Backend_Project.repositories.ReviewRepository;
import com.example.BNTA_Backend_Project.repositories.UserRepository;
import com.example.BNTA_Backend_Project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    private User user;
    private Movie movie;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<>(reviewRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Review>> getMovieById(@PathVariable Long id){
        return new ResponseEntity<>(reviewRepository.findById(id), HttpStatus.OK);
    }

    //TODO check whether we need "List<Movie>"

    //TODO figure out post mapping for reviews
    @PostMapping
    public ResponseEntity<Review> addReview(
            @RequestBody Review review,
            @RequestParam(name = "user_id") Long user_id,
            @RequestParam(name = "movie_id") Long movie_id){
            User user = userRepository.findById(user_id).get();
            Movie movie = movieRepository.findById(movie_id).get();
            review.setUser(user);
            review.setMovie(movie);
            reviewRepository.save(review);
            //Return updated review
            return new ResponseEntity<>(review, HttpStatus.CREATED);
        }

    @PatchMapping (value = "/{id}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable Long id){
        Review reviewToUpdate = reviewRepository.findById(id).get();
        reviewToUpdate.setReviewBody(review.getReviewBody());
        reviewToUpdate.setRating(review.getRating());
        reviewRepository.save(review);
        return new ResponseEntity<>(reviewToUpdate, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteReview(@PathVariable Long id){
        reviewRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}

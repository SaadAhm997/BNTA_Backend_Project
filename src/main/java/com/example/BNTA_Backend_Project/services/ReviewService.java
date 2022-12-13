package com.example.BNTA_Backend_Project.services;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.models.User;
import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import com.example.BNTA_Backend_Project.repositories.ReviewRepository;
import com.example.BNTA_Backend_Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {

        return reviewRepository.findById(id).get();
    }

//    @PostMapping
//    public ResponseEntity<Review> addReview(
//            @RequestBody Review review,
//            @RequestParam(name = "user_id") Long user_id,
//            @RequestParam(name = "movie_id") Long movie_id){
//        User user = userRepository.findById(user_id).get();
//        Movie movie = movieRepository.findById(movie_id).get();
//        review.setUser(user);
//        review.setMovie(movie);
//        reviewRepository.save(review);
//        //Return updated review
//        return new ResponseEntity<>(review, HttpStatus.CREATED);

    /*
    Logic:
    Finding the user by id
    finding movie by id
    adding users to review

     */

    public void addReview(Review review) {

        review.setUser(user);
        review.setMovie(movie);
        reviewRepository.save(review);
        //Return updated review
        
    }
    public Review updateReview(Review review, Long id) {
        Review reviewToUpdate = reviewRepository.findById(id).get();
        reviewToUpdate.setReviewBody(review.getReviewBody());
        reviewToUpdate.setRating(review.getRating());
        return reviewRepository.save(reviewToUpdate);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}

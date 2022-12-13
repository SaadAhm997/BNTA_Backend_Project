package com.example.BNTA_Backend_Project.services;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.models.User;
import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import com.example.BNTA_Backend_Project.repositories.ReviewRepository;
import com.example.BNTA_Backend_Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Review addReview(Review review, Long user_id, Long movie_id) {
        User user = userRepository.findById(user_id).get();
        Movie movie = movieRepository.findById(movie_id).get();
        review.setUser(user);
        review.setMovie(movie);
        reviewRepository.save(review);
        return review;
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

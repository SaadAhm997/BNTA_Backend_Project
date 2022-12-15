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

    public Review addReview(Review review){
        User user = userRepository.findById(review.getUser().getId()).get();
        Movie movie = movieRepository.findById(review.getMovie().getId()).get();
        review.setUser(user);
        review.setMovie(movie);
        //userService.addUserCrypto(user.getId());
        user.addCryptoPoints();
        // still saves here
        userRepository.save(user);
        reviewRepository.save(review);
        return review; 
    }

    public Review updateReview(Review review, Long id) {
        Review reviewToUpdate = reviewRepository.findById(id).get();
        if(review.getReviewBody() != null){
            reviewToUpdate.setReviewBody(review.getReviewBody());}
        //if not null, update
        if(review.getRating() != 0 && review.getRating() <= 10){
            reviewToUpdate.setRating(review.getRating());
        }
        return reviewRepository.save(reviewToUpdate);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    //filters: rating, movie id, movie title, user id, user name
    public List<Review> findReviewByRating(int rating){
        return reviewRepository.findByRating(rating);
    }

    public List<Review> findReviewByReviewBody(String reviewBody){
        return reviewRepository.findByReviewBody(reviewBody);
    }
    public List<Review> findReviewByMovieId(Long movieId){
        return reviewRepository.findByMovieId(movieId);
    }
    public List<Review> findReviewByMovieTitle(String movieTitle){
        return reviewRepository.findByMovieTitle(movieTitle);
    }
    public List<Review> findReviewByUserId(Long userId){
        return reviewRepository.findByUserId(userId);
    }
    public List<Review> findReviewByUserName(String userName){
        return reviewRepository.findByUserName(userName);
    }

}

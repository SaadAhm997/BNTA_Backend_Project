package com.example.BNTA_Backend_Project.repositories;

import com.example.BNTA_Backend_Project.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByRating(int rating);
    List<Review> findByReviewBody(String reviewBody);
    List<Review> findByMovieId(Long movieId);
    List<Review> findByMovieTitle(String movieTitle);
    List<Review> findByUserId(Long userId);
    List<Review> findByUserName(String userName);
}

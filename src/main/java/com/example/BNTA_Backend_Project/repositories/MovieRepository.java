package com.example.BNTA_Backend_Project.repositories;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByGenre(String genre);
    List<Movie> findByYear(int year);
    List<Movie> findByDuration(int duration);
    List<Movie> findByTitle(String title);
}

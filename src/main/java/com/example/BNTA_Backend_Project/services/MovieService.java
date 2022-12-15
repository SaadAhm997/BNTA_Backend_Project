package com.example.BNTA_Backend_Project.services;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.models.User;
import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ReviewService reviewService;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie, Long id) {
        Movie movieToUpdate = movieRepository.findById(id).get();
        if(movie.getTitle() != null) {
            movieToUpdate.setTitle(movie.getTitle());
        }
        if (movie.getGenre() !=null ) {
            movieToUpdate.setGenre(movie.getGenre());
        }
        if (movie.getDuration() >=0 && movie.getDuration() <=1_000_000) {
            movieToUpdate.setDuration(movie.getDuration());
        }
        if (movie.getYear() >=1800 && movie.getYear() <2022)
        movieToUpdate.setYear(movie.getYear());
        return movieRepository.save(movieToUpdate);
    }

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).get();
        List<Review> reviews = movie.getReviews();
        for (Review review : reviews){
            reviewService.deleteReview((review.getId()));
        }
        movieRepository.deleteById(id);
    }

    //filters: genre, year, duration, title
    public List<Movie> findMovieByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> findMovieByYear(int year){
        return movieRepository.findByYear(year);
    }
    public List<Movie> findMovieByDuration(int duration){
        return movieRepository.findByDuration(duration);
    }
    public List<Movie> findMovieByTitle(String title){
        return movieRepository.findByTitle(title);
    }

}

package com.example.BNTA_Backend_Project.services;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

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
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setDuration(movie.getDuration());
        return movieRepository.save(movieToUpdate);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    //find by genre
    public List<Movie> findMovieByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> findMovieByYear(Integer year){
        return movieRepository.findByYear(year);
    }
}

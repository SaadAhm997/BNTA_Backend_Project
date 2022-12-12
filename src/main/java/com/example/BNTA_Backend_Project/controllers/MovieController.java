package com.example.BNTA_Backend_Project.controllers;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.repositories.MovieRepository;
import com.example.BNTA_Backend_Project.services.MovieService;
import com.example.BNTA_Backend_Project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id){
        return new ResponseEntity<>(movieRepository.findById(id), HttpStatus.OK);
    }

    //TODO check whether we need "List<Movie>"
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieRepository.save(movie), HttpStatus.CREATED);
    }

    @PatchMapping (value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id){
        Movie movieToUpdate = movieRepository.findById(id).get();
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setDuration(movie.getDuration()); 
        movieRepository.save(movieToUpdate);
        return new ResponseEntity<>(movieToUpdate, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}

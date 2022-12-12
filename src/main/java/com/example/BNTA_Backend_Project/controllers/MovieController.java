package com.example.BNTA_Backend_Project.controllers;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.models.Review;
import com.example.BNTA_Backend_Project.services.MovieService;
import com.example.BNTA_Backend_Project.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Movie>> getMovieById(@PathVariable Long id){
        return null;
    }

    //TODO check whether we need "List<Movie>"
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id){
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteMovie(@PathVariable Long id){
        return null;
    }

}

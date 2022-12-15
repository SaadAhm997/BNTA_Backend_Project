package com.example.BNTA_Backend_Project.controllers;

import com.example.BNTA_Backend_Project.models.Movie;
import com.example.BNTA_Backend_Project.services.MovieService;
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
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMoviesAndFilters(
            @RequestParam(required = false, name = "genre") Optional<String> genre,
            @RequestParam(required = false, name = "year") Optional<Integer> year,
            @RequestParam(required = false, name = "duration") Optional<Integer> duration,
            @RequestParam(required = false, name = "title") Optional<String> title
    ){
        if(genre.isPresent()){
            return new ResponseEntity<>(movieService.findMovieByGenre(genre.get()), HttpStatus.OK);
        }
        if(year.isPresent()){
            return new ResponseEntity<>(movieService.findMovieByYear(year.get()), HttpStatus.OK);
        }
        if(duration.isPresent()){
            return new ResponseEntity<>(movieService.findMovieByDuration(duration.get()), HttpStatus.OK);
        }
        if(title.isPresent()){
            return new ResponseEntity<>(movieService.findMovieByTitle(title.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id){
        return new ResponseEntity(movieService.getMovieById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PatchMapping (value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id){
        var updated = movieService.updateMovie(movie, id);
        return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}

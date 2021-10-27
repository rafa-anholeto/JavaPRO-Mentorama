package com.example.movieProject.controllers;

import com.example.movieProject.entities.Movies;
import com.example.movieProject.services.IMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final List<Movies> moviesList;

    private final IMovieService movieService;


    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
        this.moviesList = new ArrayList<>();
    }

    @GetMapping
    public List<Movies> findAll(@RequestParam(required = false) final String movies){
        return movieService.findAll(movies);
    }

    @GetMapping("/{Name}")
    public List<Movies> findMovies(@PathVariable("Name") final String name) {
        return movieService.findMovies(name);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody final Movies movies){
        movieService.add(movies);
        String filmCreated = "Filme criado! Id: "+ movies.getId();
        return new ResponseEntity<String>(filmCreated, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateMovie(@RequestBody final Movies movies){
        movieService.updateMovie(movies);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") Integer id){
        movieService.deleteMovie(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

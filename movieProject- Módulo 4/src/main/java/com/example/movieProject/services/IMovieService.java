package com.example.movieProject.services;

import com.example.movieProject.entities.Movies;


import java.util.List;

public interface IMovieService {

    List<Movies> findAll(final String movies);
    Movies add(final Movies movies);
    List<Movies> findMovies(final String name);
    void updateMovie(final Movies movies);
    void deleteMovie(Integer id);
}

package com.example.movieProject.services;

import com.example.movieProject.entities.Movies;
import com.example.movieProject.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {


    private MovieRepository movieRepository = MovieRepository.getInstance();
    private final List<Movies> moviesList;

    public MovieService() {
        this.moviesList = new ArrayList<>();
    }

    public List<Movies> findAll(String movies){
        if(movies != null){
            return movieRepository.findAll(movies);
        }
        return movieRepository.findAll();
    }

    public List<Movies> findMovies(final String name) {
        return movieRepository.findMovies(name);
    }

    public Movies add(final Movies movies){
        this.moviesList.add(movies);
        return movieRepository.add(movies);
    }

    public void updateMovie(Movies movies){
        movieRepository.updateMovie(movies);
    }

    public void deleteMovie(Integer id){
        movieRepository.deleteMovie(id);
    }






}

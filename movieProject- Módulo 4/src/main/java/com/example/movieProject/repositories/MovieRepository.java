package com.example.movieProject.repositories;

import com.example.movieProject.exceptions.sameIdException;
import com.example.movieProject.entities.Movies;
import com.example.movieProject.exceptions.sameMovieException;
import com.example.movieProject.exceptions.wrongNoteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {

    private static MovieRepository movieRepository;


    private final List<Movies> moviesList;

    public MovieRepository(){
        this.moviesList = new ArrayList<>();
    }

    public static MovieRepository getInstance(){
        if(movieRepository == null){
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public List<Movies> findAll() {
        return moviesList;
    }

    public List<Movies> findAll(final String movies){
        List<Movies> findedMovies = new ArrayList<>(moviesList.stream().filter(mov -> mov.getName().contains(movies)).collect(Collectors.toList()));
        return findedMovies;
    }

    public List<Movies> findMovies(final String name) {
        return this.moviesList.stream().filter(mov -> mov.getName().contains(name)).collect(Collectors.toList());
    }

    public int count(){
        return moviesList.size();
    }

    public Movies add(Movies movies){
        if(moviesList.stream().anyMatch(mov -> mov.getId().equals(movies.getId()))){
            throw new sameIdException();
        }
        if(moviesList.stream().anyMatch(mov -> mov.getName().equalsIgnoreCase(movies.getName())) &&
                moviesList.stream().anyMatch(mov -> mov.getDirectorName().equalsIgnoreCase(movies.getDirectorName())) &&
                moviesList.stream().anyMatch(mov -> mov.getYear().equals(movies.getYear()))){
            throw new sameMovieException();
        }
        if(movies.getId() == null){
            movies.setId(movieRepository.count()+1);
        }
        if(movies.getNote() <=1 || movies.getNote() >5){
            throw new wrongNoteException();
        }
        this.moviesList.add(movies);
        return movies;
    }

    public void updateMovie(Movies movies){
        moviesList.stream().filter(mov ->mov.getId().equals(movies.getId())).
                forEach(mov -> mov.setName(movies.getName()));

        moviesList.stream().filter(mov ->mov.getId().equals(movies.getId())).
                forEach(mov -> mov.setDirectorName(movies.getDirectorName()));

        moviesList.stream().filter(mov ->mov.getId().equals(movies.getId())).
                forEach(mov -> mov.setYear(movies.getYear()));

        moviesList.stream().filter(mov ->mov.getId().equals(movies.getId())).
                forEach(mov -> mov.setNote(movies.getNote()));
    }

    public ResponseEntity deleteMovie(@PathVariable("id") Integer id){
        moviesList.removeIf(mov -> mov.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }






}

package com.example.movieProject.controllers;

import com.example.movieProject.exceptions.sameIdException;
import com.example.movieProject.exceptions.sameMovieException;
import com.example.movieProject.exceptions.wrongNoteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    @ExceptionHandler({sameIdException.class})
    public ResponseEntity<String> resolveExceptions(final sameIdException e) {
        return new ResponseEntity("Id repetido, tente novamente utilizando outro Id!", HttpStatus.CONFLICT);
    }

    @ExceptionHandler({wrongNoteException.class})
    public ResponseEntity<String> resolveExceptions(final wrongNoteException e){
        return new ResponseEntity<>("Nota inválida, por favor, entre com uma nota no sistema de valor(1-5).",HttpStatus.CONFLICT);
    }

    @ExceptionHandler({sameMovieException.class})
    public ResponseEntity<String> resolveExceptions(final sameMovieException e){
        return new ResponseEntity<>("Mesmo filme, digite outro filme.",HttpStatus.NOT_ACCEPTABLE);
    }
}

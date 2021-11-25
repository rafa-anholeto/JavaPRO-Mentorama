package com.example.productAPI.controllers;

import com.example.productAPI.exceptions.sameNameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    @ExceptionHandler({sameNameException.class})
    public ResponseEntity<String> resolveExceptions(final sameNameException e) {
        return new ResponseEntity("Produto repetido, tente novamente utilizando outro Id!", HttpStatus.CONFLICT);
    }
}

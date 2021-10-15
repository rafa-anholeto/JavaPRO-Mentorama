package com.example.exspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler({AlunoNaoEncontradoException.class})
    public ResponseEntity resolveExceptions(final AlunoNaoEncontradoException e){
        return new ResponseEntity("Aluno não encontrado no sistema! Tente novamente.", HttpStatus.NOT_FOUND);
    }
}

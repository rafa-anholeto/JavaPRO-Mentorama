package com.example.patientsapi.controllers;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping
    public ResponseEntity<List<Doctors>> findAll(){
        return new ResponseEntity<>(doctorsService.findAll(), HttpStatus.OK);
    }
}

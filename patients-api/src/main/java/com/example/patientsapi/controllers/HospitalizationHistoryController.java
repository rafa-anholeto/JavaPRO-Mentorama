package com.example.patientsapi.controllers;

import com.example.patientsapi.Entities.HospitalizationHistory;
import com.example.patientsapi.services.HospitalizationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospitalization")
public class HospitalizationHistoryController {

    @Autowired
    private HospitalizationHistoryService hospitalizationHistoryService;

    @GetMapping
    public ResponseEntity<List<HospitalizationHistory>> findAll(){
        return new ResponseEntity<>(hospitalizationHistoryService.findAll(), HttpStatus.OK);
    }
}

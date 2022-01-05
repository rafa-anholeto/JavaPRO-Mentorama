package com.example.patientsapi.controllers;

import com.example.patientsapi.Entities.HospitalizationHistory;
import com.example.patientsapi.services.HospitalizationHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<HospitalizationHistory> findById(@PathVariable("id") Long id){
        return new ResponseEntity(hospitalizationHistoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HospitalizationHistory> create(@RequestBody HospitalizationHistory hospitalizationHistory){
        HospitalizationHistory obj = hospitalizationHistoryService.create(hospitalizationHistory);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<HospitalizationHistory> update(@RequestBody HospitalizationHistory hospitalizationHistory){
        HospitalizationHistory h1 = hospitalizationHistoryService.update(hospitalizationHistory);
        return new ResponseEntity<>(h1, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        hospitalizationHistoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}

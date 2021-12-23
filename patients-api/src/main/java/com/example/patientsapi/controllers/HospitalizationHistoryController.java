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

    @PostMapping
    public ResponseEntity<HospitalizationHistory> create(@RequestBody HospitalizationHistory hospitalizationHistory){
        HospitalizationHistory hosp = hospitalizationHistoryService.create(hospitalizationHistory);
        return new ResponseEntity<>(hosp, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HospitalizationHistory> update(@PathVariable Long id, @RequestBody HospitalizationHistory hospitalizationHistory){
        return new ResponseEntity<>(hospitalizationHistoryService.update(id, hospitalizationHistory), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        hospitalizationHistoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}

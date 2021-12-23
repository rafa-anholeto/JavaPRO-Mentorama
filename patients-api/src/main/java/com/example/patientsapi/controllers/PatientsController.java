package com.example.patientsapi.controllers;

import com.example.patientsapi.Entities.Patients;
import com.example.patientsapi.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {
    @Autowired
    private PatientsService patientsService;

    @GetMapping
    public ResponseEntity<List<Patients>> findAll(){
        return new ResponseEntity<>(patientsService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patients> create(@RequestBody Patients patients){
        Patients p1 = patientsService.create(patients);
        return new ResponseEntity<>(p1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patients>update(@PathVariable Long id, @RequestBody Patients patients){
        Patients p1 = patientsService.update(id, patients);
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        patientsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

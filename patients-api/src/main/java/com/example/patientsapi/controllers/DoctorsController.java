package com.example.patientsapi.controllers;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;

    @GetMapping
    public ResponseEntity<List<Doctors>> findAll(){
        return new ResponseEntity<>(doctorsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctors> findById(@PathVariable Long id){
        return new ResponseEntity<>(doctorsService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/countDepartments")
    public ResponseEntity<List<Doctors>> findDoctorsPerDepartment(){
        List<Doctors> list = doctorsService.findDoctorsPerDepartment();
        Map<Object, Long> collect = list.stream().collect(Collectors.groupingBy(x -> x.getDepartment(), Collectors.counting()));

        return new ResponseEntity(collect, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctors> create(@RequestBody Doctors doctors){
        return new ResponseEntity<>(doctorsService.create(doctors), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Doctors> update(@RequestBody Doctors doctors){
        return new ResponseEntity<>(doctorsService.update(doctors), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        doctorsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

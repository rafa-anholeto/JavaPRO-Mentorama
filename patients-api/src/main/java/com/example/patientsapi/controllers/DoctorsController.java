package com.example.patientsapi.controllers;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.dto.DoctorsDTO;
import com.example.patientsapi.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/count")
    public ResponseEntity<List<DoctorsDTO>> findDoctorsPerDepartment(){
        List<Doctors> list = doctorsService.findDoctorsPerDepartment();
        List<DoctorsDTO> listDto = list.stream().map(x -> new DoctorsDTO(x)).collect(Collectors.toList());
        return new ResponseEntity(listDto, HttpStatus.OK);
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

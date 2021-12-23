package com.example.patientsapi.services;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.Repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    public List<Doctors> findAll(){
        return doctorsRepository.findAll();
    }



}

package com.example.patientsapi.services;

import com.example.patientsapi.Entities.Patients;
import com.example.patientsapi.Repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {

    @Autowired
    private PatientsRepository patientsRepository;

    public List<Patients> findAll(){
        return patientsRepository.findAll();
    }
}

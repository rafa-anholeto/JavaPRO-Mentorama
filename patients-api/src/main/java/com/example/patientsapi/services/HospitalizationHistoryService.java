package com.example.patientsapi.services;

import com.example.patientsapi.Entities.HospitalizationHistory;
import com.example.patientsapi.Entities.Patients;
import com.example.patientsapi.Repositories.HospitalizationHistoryRepository;
import com.example.patientsapi.Repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizationHistoryService {

    @Autowired
    private HospitalizationHistoryRepository hospitalizationHistoryRepository;

    public List<HospitalizationHistory> findAll(){
        return hospitalizationHistoryRepository.findAll();
    }
}

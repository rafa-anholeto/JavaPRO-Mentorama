package com.example.patientsapi.services;

import com.example.patientsapi.Entities.HospitalizationHistory;
import com.example.patientsapi.Repositories.HospitalizationHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalizationHistoryService {

    @Autowired
    private HospitalizationHistoryRepository hospitalizationHistoryRepository;

    public List<HospitalizationHistory> findAll(){
        return hospitalizationHistoryRepository.findAll();
    }

    public HospitalizationHistoryRepository findById(Long id){
        Optional<HospitalizationHistory> patient = hospitalizationHistoryRepository.findById(id);
        return (HospitalizationHistoryRepository) patient.orElseThrow(() -> new RuntimeException());
    }

    public HospitalizationHistory create(HospitalizationHistory hospitalizationHistory){

        return hospitalizationHistoryRepository.save(hospitalizationHistory);
    }

    public HospitalizationHistory update(HospitalizationHistory hospitalizationHistory){
            return hospitalizationHistoryRepository.save(hospitalizationHistory);

    }
    
    public void delete(Long id){
        hospitalizationHistoryRepository.deleteById(id);
    }


}

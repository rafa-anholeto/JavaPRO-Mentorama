package com.example.patientsapi.services;

import com.example.patientsapi.Entities.HospitalizationHistory;
import com.example.patientsapi.Repositories.HospitalizationHistoryRepository;
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

    public HospitalizationHistory create(HospitalizationHistory hospitalizationHistory){
        return hospitalizationHistoryRepository.save(hospitalizationHistory);
    }

    public HospitalizationHistory update(Long id, HospitalizationHistory hospitalizationHistory){

        return hospitalizationHistoryRepository.save(hospitalizationHistory);

    }

    public void updateData(HospitalizationHistory entity, HospitalizationHistory hospitalizationHistory){
        entity.setPatientId(hospitalizationHistory.getPatientId());
        entity.setDateAndEntryPatientHour(hospitalizationHistory.getDateAndEntryPatientHour());
        entity.setDateAndExitPatientHour(hospitalizationHistory.getDateAndExitPatientHour());
        entity.setDescription(hospitalizationHistory.getDescription());
    }

    public void delete(Long id){
        hospitalizationHistoryRepository.deleteById(id);
    }
}

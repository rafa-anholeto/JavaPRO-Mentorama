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

    public Patients create(Patients patients){
        return patientsRepository.save(patients);
    }

    public Patients update(Long id,Patients patients){
        Patients entity = patientsRepository.getById(id);
        updateData(entity, patients);
        return patientsRepository.save(entity);
    }

    public void updateData(Patients entity, Patients patients){
        entity.setName(patients.getName());
        entity.setPhone(patients.getPhone());
        entity.setBirthDate(patients.getBirthDate());
    }

    public void delete(Long id){
        patientsRepository.deleteById(id);
    }
}

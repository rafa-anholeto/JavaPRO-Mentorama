package com.example.patientsapi.services;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.Repositories.DoctorsRepository;
import com.example.patientsapi.dto.DoctorsDTO;
import com.example.patientsapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    public List<Doctors> findAll(){
        return doctorsRepository.findAll();
    }

    public Doctors findById(Long id){
        Optional<Doctors> obj = doctorsRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
    }

    public List<Doctors> findDoctorsPerDepartment(){

        return doctorsRepository.findAll();
    }

    public Doctors create(Doctors doctors){
        return doctorsRepository.save(doctors);
    }

    public Doctors update(Doctors doctors){
        return doctorsRepository.save(doctors);
    }

    public void delete(Long id){
        doctorsRepository.deleteById(id);
    }

    public Doctors fromDTO(DoctorsDTO objDto){
        return new Doctors(objDto.getId(),objDto.getMedicName(), objDto.getDepartment(), objDto.getCargo(), objDto.getPhone());
    }



}

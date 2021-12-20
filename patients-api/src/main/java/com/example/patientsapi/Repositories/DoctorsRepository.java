package com.example.patientsapi.Repositories;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.Entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {
}

package com.example.patientsapi.Repositories;

import com.example.patientsapi.Entities.HospitalizationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalizationHistoryRepository extends JpaRepository<HospitalizationHistory, Long> {
}

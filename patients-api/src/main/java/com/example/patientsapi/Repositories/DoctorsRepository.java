package com.example.patientsapi.Repositories;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.Entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {

    @Query(value = "SELECT department, count(department) as department_quantity FROM tb_doctors group by department order by department_quantity desc ",
            nativeQuery = true)
    List<Doctors> findDoctorsByDepartment();
}

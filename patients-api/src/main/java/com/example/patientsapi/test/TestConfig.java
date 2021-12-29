/*package com.example.patientsapi.test;

import com.example.patientsapi.Entities.Doctors;
import com.example.patientsapi.Entities.HospitalizationHistory;
import com.example.patientsapi.Entities.Patients;
import com.example.patientsapi.Repositories.DoctorsRepository;
import com.example.patientsapi.Repositories.HospitalizationHistoryRepository;
import com.example.patientsapi.Repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PatientsRepository patientsRepository;

    @Autowired
    private HospitalizationHistoryRepository hospitalizationHistoryRepository;

    @Autowired
    private DoctorsRepository doctorsRepository;


    @Override
    public void run(String... args) throws Exception {

        patientsRepository.deleteAll();
        hospitalizationHistoryRepository.deleteAll();
        Patients p1 = new Patients(null,"João Gomes","95554-3525", "16/12/1975");
        Patients p2 = new Patients(null,"Giva Jones","95554-3525", "16/12/1975");
        Patients p3 = new Patients(null,"Joel Silva","95554-3525", "16/12/1975");
        patientsRepository.saveAll(Arrays.asList(p1,p2,p3));

        Doctors d1 = new Doctors(1111L, "José de Carvalho", 1, "Ortopedista", "8425-1580");
        Doctors d2 = new Doctors(2222L, "Renan Santos", 2, "Cardiologista", "8425-1752");
        Doctors d3 = new Doctors(3333L, "Marcelo Dias", 2, "Oftalmologista", "8425-4558");
        Doctors d4 = new Doctors(4444L, "Francisco Souza", 3, "Psiquiatra", "8425-0525");
        Doctors d5 = new Doctors(5555L, "Davi Campos", 3, "Pneumologista", "8425-8510");
        doctorsRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5));

        HospitalizationHistory h1 = new HospitalizationHistory(1L, p1,"02/11/2016 - 18:40","05/11/2016 - 11:35",
                "Flu problem", Arrays.asList(d5));
        HospitalizationHistory h2 = new HospitalizationHistory(2L, p1,"29/09/2011 - 19:40","05/10/2011 - 11:35",
                "Heart problem", Arrays.asList(d2));
        HospitalizationHistory h3 = new HospitalizationHistory(3L, p1,"25/3/2010 - 19:50","28/3/2010 - 15:35",
                "Fractured bone", Arrays.asList(d1));
        HospitalizationHistory h4 = new HospitalizationHistory(4L, p2,"10/11/2016 - 18:40", "10/11/2016 - 20:35",
                "Flu problem", Arrays.asList(d5));
        HospitalizationHistory h5 = new HospitalizationHistory(5L, p2,"20/04/2015 - 17:40", "28/04/2015 - 15:40",
                "Heart problem", Arrays.asList(d2));
        HospitalizationHistory h6 = new HospitalizationHistory(6L, p3,"16/07/2018 - 13:50", "20/07/2018 - 18:35",
                "Flu problem", Arrays.asList(d1));
        hospitalizationHistoryRepository.saveAll(Arrays.asList(h1,h2,h3,h4,h5,h6));
        p1.getHospitalizationHistory().add(h1);
        p1.getHospitalizationHistory().add(h2);
        p1.getHospitalizationHistory().add(h3);
        p2.getHospitalizationHistory().add(h4);
        p2.getHospitalizationHistory().add(h5);
        p3.getHospitalizationHistory().add(h6);
        patientsRepository.saveAll(List.of(p1,p2,p3));

    }
}*/

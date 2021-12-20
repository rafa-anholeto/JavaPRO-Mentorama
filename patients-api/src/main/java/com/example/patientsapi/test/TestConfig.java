package com.example.patientsapi.test;

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

        Patients p1 = new Patients(1L,"João Gomes","95554-3525", "16/12/1975");
        Patients p2 = new Patients(2L,"Giva Jones","95554-3525", "16/12/1975");
        Patients p3 = new Patients(3L,"Joel Silva","95554-3525", "16/12/1975");

        Doctors d1 = new Doctors(1111L, "José de Carvalho", 1, "Ortopedista", null);
        Doctors d2 = new Doctors(2222L, "Renan Santos", 2, "Cardiologista", null);
        Doctors d3 = new Doctors(3333L, "Marcelo Dias", 2, "Oftalmologista", null);
        Doctors d4 = new Doctors(4444L, "Francisco Souza", 3, "Psiquiatra", null);
        Doctors d5 = new Doctors(5555L, "Davi Campos", 3, "Penumologista", null);

        doctorsRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5));


        

        HospitalizationHistory h1 = new HospitalizationHistory("02/11/2016 - 18:40","05/11/2016 - 11:35",
                "Flu problem", 5555L,1L);

        HospitalizationHistory h2 = new HospitalizationHistory("29/09/2011 - 19:40","05/10/2011 - 11:35",
                "Heart problem", 2222L,1L);

        HospitalizationHistory h3 = new HospitalizationHistory("25/3/2010 - 19:50","28/3/2010 - 15:35",
                "Fractured bone", 1111L,1L);

        HospitalizationHistory h4 = new HospitalizationHistory("10/11/2016 - 18:40", "10/11/2016 - 20:35",
                "Flu problem", 5555L, 2L);

        HospitalizationHistory h5 = new HospitalizationHistory("20/04/2015 - 17:40", "28/04/2015 - 15:40",
                "Heart problem", 2222L,2L);

        HospitalizationHistory h6 = new HospitalizationHistory("16/07/2018 - 13:50", "20/07/2018 - 18:35",
                "Flu problem", 5555L,3L);

        hospitalizationHistoryRepository.saveAll(Arrays.asList(h1,h2,h3,h4,h5,h6));



        p1.getHospitalizationHistoryList().add(h1);
        p1.getHospitalizationHistoryList().add(h2);
        p1.getHospitalizationHistoryList().add(h3);
        patientsRepository.saveAll(Arrays.asList(p1,p2,p3));










        /*h1.setIdPatient(p1.getId());
        h2.setIdPatient(p1.getId());
        h3.setIdPatient(p1.getId());
        h4.setIdPatient(p2.getId());
        h5.setIdPatient(p2.getId());
        h6.setIdPatient(p3.getId());*/



        /*h1.setDoctorsList(List.of(d5));
        h2.setDoctorsList(List.of(d2));
        h3.setDoctorsList(List.of(d5));*/




        hospitalizationHistoryRepository.saveAll(Arrays.asList(h1,h2,h3,h4,h5,h6));
        patientsRepository.saveAll(List.of(p1,p2,p3));














    }
}

package com.example.patientsapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospitalization_history")
public class HospitalizationHistory implements Serializable {

    private String dateAndEntryPatientHour;
    private String dateAndExitPatientHour;
    private String description;
    @Id
    private Long responseDoctor;
    @JoinColumn(name = "idPatient")
    private Long idPatients;

    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "idMatricula")
    private List<Doctors> doctorsList = new ArrayList<>();

    @OneToMany
    private List<Patients> patients = new ArrayList<>();


    /*@ManyToMany
    @JoinColumn(name = "id")
    private List<Patients> patientsList;*/

    public HospitalizationHistory() {
    }

    public HospitalizationHistory(String dateAndEntryPatientHour, String dateAndExitPatientHour, String description, Long responseDoctor, Long idPatients) {
        this.dateAndEntryPatientHour = dateAndEntryPatientHour;
        this.dateAndExitPatientHour = dateAndExitPatientHour;
        this.description = description;
        this.responseDoctor = responseDoctor;
        this.idPatients = idPatients;

    }

    public String getDateAndEntryPatientHour() {
        return dateAndEntryPatientHour;
    }

    public void setDateAndEntryPatientHour(String dateAndEntryPatientHour) {
        this.dateAndEntryPatientHour = dateAndEntryPatientHour;
    }

    public String getDateAndExitPatientHour() {
        return dateAndExitPatientHour;
    }

    public void setDateAndExitPatientHour(String dateAndExitPatientHour) {
        this.dateAndExitPatientHour = dateAndExitPatientHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getResponseDoctor() {
        return responseDoctor;
    }

    public void setResponseDoctor(Long responseDoctor) {
        this.responseDoctor = responseDoctor;
    }

    /*public void setDoctorsList(List<Doctors> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public List<Doctors> getDoctorsList() {
        return doctorsList;
    }*/

    public Long getIdPatients() {
        return this.idPatients;
    }

    public void setIdPatients(Long idPatients) {
        this.idPatients = idPatients;
    }

}

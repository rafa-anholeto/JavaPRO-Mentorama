package com.example.patientsapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "hospitalization_history")
public class HospitalizationHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patients patient;

    private String dateAndEntryPatientHour;
    private String dateAndExitPatientHour;
    private String description;

    @ManyToMany
    @JoinColumn(name = "doctors")
    private List<Doctors> responseDoctor = new ArrayList<>();

    public HospitalizationHistory() {
    }

    public HospitalizationHistory(Long id, Patients patient, String dateAndEntryPatientHour, String dateAndExitPatientHour, String description,
                                  List<Doctors> responseDoctor) {

        this.id = id;
        this.patient = patient;
        this.dateAndEntryPatientHour = dateAndEntryPatientHour;
        this.dateAndExitPatientHour = dateAndExitPatientHour;
        this.description = description;
        this.responseDoctor = responseDoctor;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
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

    public List<Doctors> getResponseDoctor() {
        return responseDoctor;
    }

    public void setResponseDoctor(List<Doctors> responseDoctor) {
        this.responseDoctor = responseDoctor;
    }
}

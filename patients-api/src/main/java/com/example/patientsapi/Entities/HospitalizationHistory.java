package com.example.patientsapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "tb_hospitalization_history")
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

    @OneToMany
    private List<Doctors> doctor = new ArrayList<>();

    public HospitalizationHistory() {
    }

    public HospitalizationHistory(Long id, Patients patient, String dateAndEntryPatientHour, String dateAndExitPatientHour, String description,
                                  List<Doctors> doctor) {

        this.id = id;
        this.patient = patient;
        this.dateAndEntryPatientHour = dateAndEntryPatientHour;
        this.dateAndExitPatientHour = dateAndExitPatientHour;
        this.description = description;
        this.doctor = doctor;


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

    public List<Doctors> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<Doctors> doctor) {
        this.doctor = doctor;
    }


}

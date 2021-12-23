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


    
    private Long patientId;
    @Id
    private String dateAndEntryPatientHour;
    private String dateAndExitPatientHour;
    private String description;

    //private Long responseDoctor;



    @ManyToMany
    @JoinColumn(name = "doctors")
    private List<Doctors> responseDoctor = new ArrayList<>();

    @ManyToMany
    private List<Patients> patients = new ArrayList<>();








    public HospitalizationHistory() {
    }

    public HospitalizationHistory(Long patientId, String dateAndEntryPatientHour, String dateAndExitPatientHour, String description,
                                  List<Doctors> responseDoctor) {

        this.patientId = patientId;
        this.dateAndEntryPatientHour = dateAndEntryPatientHour;
        this.dateAndExitPatientHour = dateAndExitPatientHour;
        this.description = description;
        this.responseDoctor = responseDoctor;


    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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


    /*public List<Patients> getPatients() {
        return patients;
    }*/


}

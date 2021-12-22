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

    @Id
    @JoinColumn(name = "idPatient")
    private Long idPatients;

    private String dateAndEntryPatientHour;
    private String dateAndExitPatientHour;
    private String description;

    //private Long responseDoctor;

    @ManyToMany
    @JoinColumn(name = "doctors")
    private List<Doctors> responseDoctor = new ArrayList<>();




    @ManyToMany
    @JoinColumn(name = "hospitalization_history_idPatients")
    private List<Patients> patients = new ArrayList<>();


    /*@ManyToMany
    @JoinColumn(name = "id")
    private List<Patients> patientsList;*/

    public HospitalizationHistory() {
    }

    public HospitalizationHistory(Long idPatients, String dateAndEntryPatientHour, String dateAndExitPatientHour, String description,
                                  List<Doctors> responseDoctor) {
        this.idPatients = idPatients;
        this.dateAndEntryPatientHour = dateAndEntryPatientHour;
        this.dateAndExitPatientHour = dateAndExitPatientHour;
        this.description = description;
        this.responseDoctor = responseDoctor;

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

    /*public Long getResponseDoctor() {
        return responseDoctor;
    }

    public void setResponseDoctor(Long responseDoctor) {
        this.responseDoctor = responseDoctor;
    }*/


    public Long getIdPatients() {
        return this.idPatients;
    }

    public void setIdPatients(Long idPatients) {
        this.idPatients = idPatients;
    }

    public List<Doctors> getResponseDoctor() {
        return responseDoctor;
    }

    /*public List<Patients> getPatients() {
        return patients;
    }*/
}

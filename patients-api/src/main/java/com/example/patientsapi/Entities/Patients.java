package com.example.patientsapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "patients")
public class Patients implements Serializable {
    @Id
    @JoinColumn(name = "idPatients")
    private Long idPatient;
    private String name;
    private String phone;
    private String birthDate;

    @ManyToMany
    @JoinTable(name = "patients_hospitalization_history")
    private List<HospitalizationHistory> hospitalizationHistoryList = new ArrayList<>();

    public Patients() {
    }

    public Patients(Long idPatient, String name, String phone, String birthDate) {
        this.idPatient = idPatient;
        this.name = name;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<HospitalizationHistory> getHospitalizationHistoryList() {
        return hospitalizationHistoryList;
    }

    public void setHospitalizationHistoryList(List<HospitalizationHistory> hospitalizationHistoryList) {
        this.hospitalizationHistoryList = hospitalizationHistoryList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patients = (Patients) o;
        return idPatient.equals(patients.idPatient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatient);
    }
}

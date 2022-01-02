

package com.example.patientsapi.Entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_patients")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Patients implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String birthDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HospitalizationHistory> hospitalizationHistory = new ArrayList<>();

    public Patients() {
    }

    public Patients(Long patientId, String name, String phone, String birthDate) {
        this.id = patientId;
        this.name = name;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long patientId) {
        this.id = patientId;
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

    public List<HospitalizationHistory> getHospitalizationHistory() {
        return hospitalizationHistory;
    }

    public void setHospitalizationHistory(List<HospitalizationHistory> hospitalizationHistoryList) {
        this.hospitalizationHistory = hospitalizationHistoryList;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patients = (Patients) o;
        return id.equals(patients.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
package com.example.patientsapi.Entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Doctors implements Serializable {

    @Id
    private Long doctorId;


    private String medicName;
    private Integer department;
    private String cargo;
    private String phone;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "responseDoctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HospitalizationHistory> hospitalizationHistory = new ArrayList<>();



    public Doctors() {
    }

    public Doctors(Long doctorId, String medicName, Integer department, String cargo, String phone) {
        this.doctorId = doctorId;
        this.medicName = medicName;
        this.department = department;
        this.cargo = cargo;
        this.phone = phone;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getMedicName() {
        return medicName;
    }

    public void setMedicName(String medicName) {
        this.medicName = medicName;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<HospitalizationHistory> getHospitalizationHistory() {
        return hospitalizationHistory;
    }

    public void setHospitalizationHistory(List<HospitalizationHistory> hospitalizationHistory) {
        this.hospitalizationHistory = hospitalizationHistory;
    }

}

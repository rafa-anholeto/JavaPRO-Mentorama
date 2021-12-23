package com.example.patientsapi.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "doctors")
public class Doctors implements Serializable {

    @Id
    @JoinColumn(name = "responseDoctor")
    private Long doctorId;


    private String medicName;
    private Integer department;
    private String cargo;
    private String phone;



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


}

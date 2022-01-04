package com.example.patientsapi.dto;

import com.example.patientsapi.Entities.Doctors;

import java.io.Serializable;

public class DoctorsDTO implements Serializable {

    private Long id;

    private String medicName;
    private Integer department;
    private String cargo;
    private String phone;

    public DoctorsDTO() {
    }

    public DoctorsDTO(Doctors obj) {
        id = obj.getId();
        medicName = obj.getMedicName();
        department = obj.getDepartment();
        cargo = obj.getCargo();
        phone = obj.getPhone();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

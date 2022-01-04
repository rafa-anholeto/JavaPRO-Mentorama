package com.example.patientsapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_doctors")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Doctors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicName;
    private Integer department;
    private String cargo;
    private String phone;



    public Doctors() {
    }

    public Doctors(Long id, String medicName, Integer department, String cargo, String phone) {

        this.id = id;
        this.medicName = medicName;
        this.department = department;
        this.cargo = cargo;
        this.phone = phone;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctors doctors = (Doctors) o;
        return Objects.equals(id, doctors.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.example.patientsapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_doctors")
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

    public List<Doctors> convertClass(List<Doctors> list){
        Map<Object, Long> collect = list.stream().collect(Collectors.groupingBy(x -> x.getDepartment(), Collectors.counting()));
        return list;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctors)) return false;
        Doctors that = (Doctors) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

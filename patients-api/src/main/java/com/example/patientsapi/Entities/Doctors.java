package com.example.patientsapi.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctors implements Serializable {

    @Id
    @JoinColumn(name = "responseDoctor")
    private Long idMatricula;


    private String nomeMedico;
    private Integer department;
    private String cargo;
    private String phone;



    public Doctors() {
    }

    public Doctors(Long idMatricula, String nomeMedico, Integer department, String cargo, String phone) {
        this.idMatricula = idMatricula;
        this.nomeMedico = nomeMedico;
        this.department = department;
        this.cargo = cargo;
        this.phone = phone;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
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

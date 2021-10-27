package com.example.movieProject.entities;

public class Movies {
    private Integer id;
    private String name;
    private String directorName;
    private String year;
    private Integer note;

    public Movies(Integer id,String name, String directorName, String year, Integer note) {
        this.id = id;
        this.name = name;
        this.directorName = directorName;
        this.year = year;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directorName='" + directorName + '\'' +
                ", year=" + year +
                ", note=" + note +
                '}';
    }
}

package com.gardenforest.studentregistrationweb;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name="Student")
@Table(name="students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal scholarship;
    private Integer universityId;

    public StudentEntity() {
    }

    public StudentEntity(Integer id, String name, String surname, Integer age, BigDecimal scholarship, Integer universityId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.scholarship = scholarship;
        this.universityId = universityId;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getScholarship() {
        return scholarship;
    }

    public void setScholarship(BigDecimal scholarship) {
        this.scholarship = scholarship;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", scholarship=" + scholarship +
                ", universityId=" + universityId;
    }
}

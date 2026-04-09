package com.hibernate.model;

import javax.persistence.Entity;

@Entity
public class StudentUser extends User {

    private String university;

    public StudentUser() {
    }

    public StudentUser(String name, int age, String university) {
        super(name, age);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
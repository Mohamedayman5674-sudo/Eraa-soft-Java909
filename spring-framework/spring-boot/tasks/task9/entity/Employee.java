package com.spring.demo.spring_boot909.task9.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "EmployeeTask9")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private double salary;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Email> emails;
}
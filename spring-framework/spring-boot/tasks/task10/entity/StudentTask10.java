package com.spring.demo.spring_boot909.task10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Student10")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTask10 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<TeacherTask10> teachers;
}
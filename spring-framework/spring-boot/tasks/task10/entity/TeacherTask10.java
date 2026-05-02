package com.spring.demo.spring_boot909.task10.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Teacher10")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherTask10 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "teacher_student_10",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentTask10> students;
}
package com.spring.demo.spring_boot909.task9.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;     // gmail, yahoo
    private String content;  // actual email

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
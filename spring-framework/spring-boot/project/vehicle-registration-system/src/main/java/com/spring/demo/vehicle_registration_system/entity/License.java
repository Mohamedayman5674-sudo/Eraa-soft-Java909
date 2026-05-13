package com.spring.demo.vehicle_registration_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "licenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
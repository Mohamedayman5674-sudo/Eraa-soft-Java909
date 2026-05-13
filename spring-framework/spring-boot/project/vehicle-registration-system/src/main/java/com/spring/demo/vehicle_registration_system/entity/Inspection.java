package com.spring.demo.vehicle_registration_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "inspections")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate inspectionDate;

    private LocalDate validUntil;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
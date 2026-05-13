package com.spring.demo.vehicle_registration_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double amount;

    private String reason;

    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
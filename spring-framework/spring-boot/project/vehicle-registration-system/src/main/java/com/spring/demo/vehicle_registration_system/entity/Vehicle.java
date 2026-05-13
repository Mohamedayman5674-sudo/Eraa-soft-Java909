package com.spring.demo.vehicle_registration_system.entity;

import com.spring.demo.vehicle_registration_system.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String plateNumber;

    private String model;

    private String brand;

    private Integer year;

    @Enumerated(EnumType.STRING)
    private VehicleStatus status;

    // Many vehicles -> One user
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToOne(mappedBy = "vehicle")
    private License license;

    @OneToMany(mappedBy = "vehicle")
    private List<Inspection> inspections;

    @OneToMany(mappedBy = "vehicle")
    private List<Fine> fines;

}
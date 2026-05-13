package com.spring.demo.vehicle_registration_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "system_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;

}
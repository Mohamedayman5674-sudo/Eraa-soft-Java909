package com.spring.demo.vehicle_registration_system.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LicenseDto {

    private Long id;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private Long vehicleId;

}
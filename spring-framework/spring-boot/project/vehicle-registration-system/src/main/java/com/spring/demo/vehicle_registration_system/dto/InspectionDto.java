package com.spring.demo.vehicle_registration_system.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InspectionDto {

    private Long id;

    private LocalDate inspectionDate;

    private LocalDate validUntil;

    private String notes;

    private Long vehicleId;

}
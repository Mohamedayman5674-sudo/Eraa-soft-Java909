package com.spring.demo.vehicle_registration_system.dto;

import com.spring.demo.vehicle_registration_system.enums.VehicleStatus;
import lombok.Data;

@Data
public class VehicleDto {

    private Long id;

    private String plateNumber;

    private String model;

    private String brand;

    private Integer year;

    private VehicleStatus status;

    private Long ownerId;

}
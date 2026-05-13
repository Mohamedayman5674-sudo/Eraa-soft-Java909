package com.spring.demo.vehicle_registration_system.dto;

import lombok.Data;

@Data
public class FineDto {

    private Long id;

    private Double amount;

    private String reason;

    private Boolean paid;

    private Long vehicleId;

}
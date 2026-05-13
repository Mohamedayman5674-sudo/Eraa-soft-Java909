package com.spring.demo.vehicle_registration_system.service;

import com.spring.demo.vehicle_registration_system.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    VehicleDto createVehicle(VehicleDto vehicleDto);

    VehicleDto getVehicleById(Long id);

    List<VehicleDto> getAllVehicles();

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void deleteVehicle(Long id);

}
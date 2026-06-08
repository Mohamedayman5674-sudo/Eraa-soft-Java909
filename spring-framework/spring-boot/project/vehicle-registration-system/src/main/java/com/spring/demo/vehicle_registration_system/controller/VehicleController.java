package com.spring.demo.vehicle_registration_system.controller;

import com.spring.demo.vehicle_registration_system.dto.VehicleDto;
import com.spring.demo.vehicle_registration_system.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // CREATE VEHICLE
    @PostMapping
    public VehicleDto createVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleService.createVehicle(vehicleDto);
    }

    // GET VEHICLE BY ID
    @GetMapping("/{id}")
    public VehicleDto getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // GET ALL VEHICLES
    @GetMapping
    public List<VehicleDto> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // UPDATE VEHICLE
    @PutMapping
    public VehicleDto updateVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleService.updateVehicle(vehicleDto);
    }

    // DELETE VEHICLE
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}

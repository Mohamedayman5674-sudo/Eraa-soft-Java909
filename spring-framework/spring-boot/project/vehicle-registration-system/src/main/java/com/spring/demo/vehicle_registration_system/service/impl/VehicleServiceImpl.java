package com.spring.demo.vehicle_registration_system.service.impl;

import com.spring.demo.vehicle_registration_system.dto.VehicleDto;
import com.spring.demo.vehicle_registration_system.entity.User;
import com.spring.demo.vehicle_registration_system.entity.Vehicle;
import com.spring.demo.vehicle_registration_system.helper.BundleMessageService;
import com.spring.demo.vehicle_registration_system.repo.UserRepo;
import com.spring.demo.vehicle_registration_system.repo.VehicleRepo;
import com.spring.demo.vehicle_registration_system.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepo vehicleRepo;
    private final UserRepo userRepo;
    private final BundleMessageService bundleMessageService;

    @Autowired
    public VehicleServiceImpl(
            VehicleRepo vehicleRepo,
            UserRepo userRepo,
            BundleMessageService bundleMessageService) {

        this.vehicleRepo = vehicleRepo;
        this.userRepo = userRepo;
        this.bundleMessageService = bundleMessageService;
    }

    // CREATE
    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {

        if (vehicleDto.getPlateNumber() == null
                || vehicleDto.getPlateNumber().isBlank()) {

            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.vehicle.plate.required"));
        }

        if (vehicleDto.getOwnerId() == null) {

            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.vehicle.owner.required"));
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setPlateNumber(vehicleDto.getPlateNumber());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setYear(vehicleDto.getYear());
        vehicle.setStatus(vehicleDto.getStatus());

        User owner = userRepo.findById(vehicleDto.getOwnerId())
                .orElse(null);

        vehicle.setOwner(owner);

        vehicle = vehicleRepo.save(vehicle);

        vehicleDto.setId(vehicle.getId());

        return vehicleDto;
    }

    // GET BY ID
    @Override
    public VehicleDto getVehicleById(Long id) {

        Vehicle vehicle = vehicleRepo.findById(id)
                .orElse(null);

        if (vehicle == null) {
            return null;
        }

        VehicleDto dto = new VehicleDto();

        dto.setId(vehicle.getId());
        dto.setPlateNumber(vehicle.getPlateNumber());
        dto.setModel(vehicle.getModel());
        dto.setBrand(vehicle.getBrand());
        dto.setYear(vehicle.getYear());
        dto.setStatus(vehicle.getStatus());

        if (vehicle.getOwner() != null) {
            dto.setOwnerId(vehicle.getOwner().getId());
        }

        return dto;
    }

    // GET ALL
    @Override
    public List<VehicleDto> getAllVehicles() {

        List<Vehicle> vehicles = vehicleRepo.findAll();

        return vehicles.stream().map(vehicle -> {

            VehicleDto dto = new VehicleDto();

            dto.setId(vehicle.getId());
            dto.setPlateNumber(vehicle.getPlateNumber());
            dto.setModel(vehicle.getModel());
            dto.setBrand(vehicle.getBrand());
            dto.setYear(vehicle.getYear());
            dto.setStatus(vehicle.getStatus());

            if (vehicle.getOwner() != null) {
                dto.setOwnerId(vehicle.getOwner().getId());
            }

            return dto;

        }).collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {

        if (vehicleDto.getPlateNumber() == null
                || vehicleDto.getPlateNumber().isBlank()) {

            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.vehicle.plate.required"));
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleDto.getId());
        vehicle.setPlateNumber(vehicleDto.getPlateNumber());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setYear(vehicleDto.getYear());
        vehicle.setStatus(vehicleDto.getStatus());

        User owner = userRepo.findById(vehicleDto.getOwnerId())
                .orElse(null);

        vehicle.setOwner(owner);

        vehicleRepo.save(vehicle);

        return vehicleDto;
    }

    // DELETE
    @Override
    public void deleteVehicle(Long id) {

        vehicleRepo.deleteById(id);
    }
}

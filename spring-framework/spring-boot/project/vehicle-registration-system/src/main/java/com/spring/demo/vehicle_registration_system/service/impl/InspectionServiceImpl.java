package com.spring.demo.vehicle_registration_system.service.impl;

import com.spring.demo.vehicle_registration_system.dto.InspectionDto;
import com.spring.demo.vehicle_registration_system.entity.Inspection;
import com.spring.demo.vehicle_registration_system.entity.Vehicle;
import com.spring.demo.vehicle_registration_system.repo.InspectionRepo;
import com.spring.demo.vehicle_registration_system.repo.VehicleRepo;
import com.spring.demo.vehicle_registration_system.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepo inspectionRepo;
    private final VehicleRepo vehicleRepo;

    @Autowired
    public InspectionServiceImpl(InspectionRepo inspectionRepo,
                                 VehicleRepo vehicleRepo) {

        this.inspectionRepo = inspectionRepo;
        this.vehicleRepo = vehicleRepo;
    }

    // CREATE
    @Override
    public InspectionDto createInspection(InspectionDto inspectionDto) {

        Inspection inspection = new Inspection();

        inspection.setInspectionDate(
                inspectionDto.getInspectionDate()
        );

        inspection.setNotes(
                inspectionDto.getNotes()
        );

        // BUSINESS LOGIC
        inspection.setValidUntil(
                inspectionDto.getInspectionDate().plusMonths(6)
        );

        Vehicle vehicle = vehicleRepo.findById(
                inspectionDto.getVehicleId()
        ).orElse(null);

        inspection.setVehicle(vehicle);

        inspection = inspectionRepo.save(inspection);

        inspectionDto.setId(inspection.getId());
        inspectionDto.setValidUntil(
                inspection.getValidUntil()
        );

        return inspectionDto;
    }

    // GET BY ID
    @Override
    public InspectionDto getInspectionById(Long id) {

        Inspection inspection = inspectionRepo.findById(id)
                .orElse(null);

        if (inspection == null) {
            return null;
        }

        InspectionDto dto = new InspectionDto();

        dto.setId(inspection.getId());
        dto.setInspectionDate(
                inspection.getInspectionDate()
        );
        dto.setValidUntil(
                inspection.getValidUntil()
        );
        dto.setNotes(
                inspection.getNotes()
        );

        if (inspection.getVehicle() != null) {
            dto.setVehicleId(
                    inspection.getVehicle().getId()
            );
        }

        return dto;
    }

    // GET ALL
    @Override
    public List<InspectionDto> getAllInspections() {

        List<Inspection> inspections =
                inspectionRepo.findAll();

        return inspections.stream().map(inspection -> {

            InspectionDto dto = new InspectionDto();

            dto.setId(inspection.getId());
            dto.setInspectionDate(
                    inspection.getInspectionDate()
            );
            dto.setValidUntil(
                    inspection.getValidUntil()
            );
            dto.setNotes(
                    inspection.getNotes()
            );

            if (inspection.getVehicle() != null) {
                dto.setVehicleId(
                        inspection.getVehicle().getId()
                );
            }

            return dto;

        }).collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public InspectionDto updateInspection(
            InspectionDto inspectionDto) {

        Inspection inspection = new Inspection();

        inspection.setId(inspectionDto.getId());

        inspection.setInspectionDate(
                inspectionDto.getInspectionDate()
        );

        inspection.setNotes(
                inspectionDto.getNotes()
        );

        // BUSINESS LOGIC
        inspection.setValidUntil(
                inspectionDto.getInspectionDate().plusMonths(6)
        );

        Vehicle vehicle = vehicleRepo.findById(
                inspectionDto.getVehicleId()
        ).orElse(null);

        inspection.setVehicle(vehicle);

        inspectionRepo.save(inspection);

        return inspectionDto;
    }

    // DELETE
    @Override
    public void deleteInspection(Long id) {

        inspectionRepo.deleteById(id);
    }
}
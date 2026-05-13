package com.spring.demo.vehicle_registration_system.controller;

import com.spring.demo.vehicle_registration_system.dto.InspectionDto;
import com.spring.demo.vehicle_registration_system.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inspections")
public class InspectionController {

    private final InspectionService inspectionService;

    @Autowired
    public InspectionController(InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    // CREATE INSPECTION
    @PostMapping
    public InspectionDto createInspection(
            @RequestBody InspectionDto inspectionDto) {

        return inspectionService.createInspection(
                inspectionDto
        );
    }

    // GET INSPECTION BY ID
    @GetMapping("/{id}")
    public InspectionDto getInspectionById(
            @PathVariable Long id) {

        return inspectionService.getInspectionById(id);
    }

    // GET ALL INSPECTIONS
    @GetMapping
    public List<InspectionDto> getAllInspections() {

        return inspectionService.getAllInspections();
    }

    // UPDATE INSPECTION
    @PutMapping
    public InspectionDto updateInspection(
            @RequestBody InspectionDto inspectionDto) {

        return inspectionService.updateInspection(
                inspectionDto
        );
    }

    // DELETE INSPECTION
    @DeleteMapping("/{id}")
    public void deleteInspection(
            @PathVariable Long id) {

        inspectionService.deleteInspection(id);
    }
}
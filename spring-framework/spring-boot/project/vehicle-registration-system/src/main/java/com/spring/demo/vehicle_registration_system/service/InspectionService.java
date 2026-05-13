package com.spring.demo.vehicle_registration_system.service;

import com.spring.demo.vehicle_registration_system.dto.InspectionDto;

import java.util.List;

public interface InspectionService {

    InspectionDto createInspection(InspectionDto inspectionDto);

    InspectionDto getInspectionById(Long id);

    List<InspectionDto> getAllInspections();

    InspectionDto updateInspection(InspectionDto inspectionDto);

    void deleteInspection(Long id);

}
package com.spring.demo.vehicle_registration_system.service;

import com.spring.demo.vehicle_registration_system.dto.FineDto;

import java.util.List;

public interface FineService {

    FineDto createFine(FineDto fineDto);

    FineDto getFineById(Long id);

    List<FineDto> getAllFines();

    FineDto updateFine(FineDto fineDto);

    void deleteFine(Long id);

}
package com.spring.demo.vehicle_registration_system.controller;

import com.spring.demo.vehicle_registration_system.dto.FineDto;
import com.spring.demo.vehicle_registration_system.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fines")
public class FineController {

    private final FineService fineService;

    @Autowired
    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    // CREATE FINE
    @PostMapping
    public FineDto createFine(
            @RequestBody FineDto fineDto) {

        return fineService.createFine(fineDto);
    }

    // GET FINE BY ID
    @GetMapping("/{id}")
    public FineDto getFineById(
            @PathVariable Long id) {

        return fineService.getFineById(id);
    }

    // GET ALL FINES
    @GetMapping
    public List<FineDto> getAllFines() {

        return fineService.getAllFines();
    }

    // UPDATE FINE
    @PutMapping
    public FineDto updateFine(
            @RequestBody FineDto fineDto) {

        return fineService.updateFine(fineDto);
    }

    // DELETE FINE
    @DeleteMapping("/{id}")
    public void deleteFine(
            @PathVariable Long id) {

        fineService.deleteFine(id);
    }
}
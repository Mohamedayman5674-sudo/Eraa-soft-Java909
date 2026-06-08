package com.spring.demo.vehicle_registration_system.controller;

import com.spring.demo.vehicle_registration_system.dto.LicenseDto;
import com.spring.demo.vehicle_registration_system.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseController {

    private final LicenseService licenseService;

    @Autowired
    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    // CREATE LICENSE
    @PostMapping
    public LicenseDto createLicense(@RequestBody LicenseDto licenseDto) {
        return licenseService.createLicense(licenseDto);
    }

    // GET LICENSE BY ID
    @GetMapping("/{id}")
    public LicenseDto getLicenseById(@PathVariable Long id) {
        return licenseService.getLicenseById(id);
    }

    // GET ALL LICENSES
    @GetMapping
    public List<LicenseDto> getAllLicenses() {
        return licenseService.getAllLicenses();
    }

    // UPDATE LICENSE
    @PutMapping
    public LicenseDto updateLicense(@RequestBody LicenseDto licenseDto) {
        return licenseService.updateLicense(licenseDto);
    }

    // DELETE LICENSE
    @DeleteMapping("/{id}")
    public void deleteLicense(@PathVariable Long id) {
        licenseService.deleteLicense(id);
    }
}

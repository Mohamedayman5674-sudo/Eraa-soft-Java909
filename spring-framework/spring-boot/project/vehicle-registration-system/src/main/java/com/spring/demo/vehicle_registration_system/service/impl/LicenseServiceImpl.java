package com.spring.demo.vehicle_registration_system.service.impl;

import com.spring.demo.vehicle_registration_system.dto.LicenseDto;
import com.spring.demo.vehicle_registration_system.entity.License;
import com.spring.demo.vehicle_registration_system.entity.Vehicle;
import com.spring.demo.vehicle_registration_system.helper.BundleMessageService;
import com.spring.demo.vehicle_registration_system.repo.LicenseRepo;
import com.spring.demo.vehicle_registration_system.repo.VehicleRepo;
import com.spring.demo.vehicle_registration_system.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepo licenseRepo;
    private final VehicleRepo vehicleRepo;
    private final BundleMessageService bundleMessageService;

    @Autowired
    public LicenseServiceImpl(
            LicenseRepo licenseRepo,
            VehicleRepo vehicleRepo,
            BundleMessageService bundleMessageService) {

        this.licenseRepo = licenseRepo;
        this.vehicleRepo = vehicleRepo;
        this.bundleMessageService = bundleMessageService;
    }

    // CREATE
    @Override
    public LicenseDto createLicense(LicenseDto licenseDto) {

        if (licenseDto.getIssueDate() == null) {
            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.license.issueDate.required"));
        }

        if (licenseDto.getVehicleId() == null) {
            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.license.vehicle.required"));
        }

        License license = new License();

        license.setIssueDate(licenseDto.getIssueDate());

        // BUSINESS LOGIC
        license.setExpiryDate(
                licenseDto.getIssueDate().plusYears(1)
        );

        Vehicle vehicle = vehicleRepo.findById(
                licenseDto.getVehicleId()
        ).orElse(null);

        license.setVehicle(vehicle);

        license = licenseRepo.save(license);

        licenseDto.setId(license.getId());
        licenseDto.setExpiryDate(license.getExpiryDate());

        return licenseDto;
    }

    // GET BY ID
    @Override
    public LicenseDto getLicenseById(Long id) {

        License license = licenseRepo.findById(id)
                .orElse(null);

        if (license == null) {
            return null;
        }

        LicenseDto dto = new LicenseDto();

        dto.setId(license.getId());
        dto.setIssueDate(license.getIssueDate());
        dto.setExpiryDate(license.getExpiryDate());

        if (license.getVehicle() != null) {
            dto.setVehicleId(
                    license.getVehicle().getId()
            );
        }

        return dto;
    }

    // GET ALL
    @Override
    public List<LicenseDto> getAllLicenses() {

        List<License> licenses = licenseRepo.findAll();

        return licenses.stream().map(license -> {

            LicenseDto dto = new LicenseDto();

            dto.setId(license.getId());
            dto.setIssueDate(license.getIssueDate());
            dto.setExpiryDate(license.getExpiryDate());

            if (license.getVehicle() != null) {
                dto.setVehicleId(
                        license.getVehicle().getId()
                );
            }

            return dto;

        }).collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public LicenseDto updateLicense(LicenseDto licenseDto) {

        if (licenseDto.getIssueDate() == null) {
            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.license.issueDate.required"));
        }

        License license = new License();

        license.setId(licenseDto.getId());
        license.setIssueDate(licenseDto.getIssueDate());

        // BUSINESS LOGIC
        license.setExpiryDate(
                licenseDto.getIssueDate().plusYears(1)
        );

        Vehicle vehicle = vehicleRepo.findById(
                licenseDto.getVehicleId()
        ).orElse(null);

        license.setVehicle(vehicle);

        licenseRepo.save(license);

        return licenseDto;
    }

    // DELETE
    @Override
    public void deleteLicense(Long id) {

        licenseRepo.deleteById(id);
    }
}

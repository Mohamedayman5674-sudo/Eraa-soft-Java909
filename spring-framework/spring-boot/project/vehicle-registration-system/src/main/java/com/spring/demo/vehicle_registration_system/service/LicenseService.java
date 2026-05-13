package com.spring.demo.vehicle_registration_system.service;

import com.spring.demo.vehicle_registration_system.dto.LicenseDto;

import java.util.List;

public interface LicenseService {

    LicenseDto createLicense(LicenseDto licenseDto);

    LicenseDto getLicenseById(Long id);

    List<LicenseDto> getAllLicenses();

    LicenseDto updateLicense(LicenseDto licenseDto);

    void deleteLicense(Long id);

}
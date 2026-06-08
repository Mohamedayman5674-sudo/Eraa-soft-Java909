package com.spring.demo.vehicle_registration_system.service.impl;

import com.spring.demo.vehicle_registration_system.dto.FineDto;
import com.spring.demo.vehicle_registration_system.entity.Fine;
import com.spring.demo.vehicle_registration_system.entity.Vehicle;
import com.spring.demo.vehicle_registration_system.helper.BundleMessageService;
import com.spring.demo.vehicle_registration_system.repo.FineRepo;
import com.spring.demo.vehicle_registration_system.repo.VehicleRepo;
import com.spring.demo.vehicle_registration_system.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineServiceImpl implements FineService {

    private final FineRepo fineRepo;
    private final VehicleRepo vehicleRepo;
    private final BundleMessageService bundleMessageService;

    @Autowired
    public FineServiceImpl(
            FineRepo fineRepo,
            VehicleRepo vehicleRepo,
            BundleMessageService bundleMessageService) {

        this.fineRepo = fineRepo;
        this.vehicleRepo = vehicleRepo;
        this.bundleMessageService = bundleMessageService;
    }

    // CREATE
    @Override
    public FineDto createFine(FineDto fineDto) {

        if (fineDto.getAmount() == null) {
            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.fine.amount.required"));
        }

        if (fineDto.getVehicleId() == null) {
            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.fine.vehicle.required"));
        }

        Fine fine = new Fine();

        fine.setAmount(fineDto.getAmount());
        fine.setReason(fineDto.getReason());
        fine.setPaid(fineDto.getPaid());

        Vehicle vehicle = vehicleRepo.findById(
                fineDto.getVehicleId()
        ).orElse(null);

        fine.setVehicle(vehicle);

        fine = fineRepo.save(fine);

        fineDto.setId(fine.getId());

        return fineDto;
    }

    // GET BY ID
    @Override
    public FineDto getFineById(Long id) {

        Fine fine = fineRepo.findById(id)
                .orElse(null);

        if (fine == null) {
            return null;
        }

        FineDto dto = new FineDto();

        dto.setId(fine.getId());
        dto.setAmount(fine.getAmount());
        dto.setReason(fine.getReason());
        dto.setPaid(fine.getPaid());

        if (fine.getVehicle() != null) {
            dto.setVehicleId(
                    fine.getVehicle().getId()
            );
        }

        return dto;
    }

    // GET ALL
    @Override
    public List<FineDto> getAllFines() {

        List<Fine> fines = fineRepo.findAll();

        return fines.stream().map(fine -> {

            FineDto dto = new FineDto();

            dto.setId(fine.getId());
            dto.setAmount(fine.getAmount());
            dto.setReason(fine.getReason());
            dto.setPaid(fine.getPaid());

            if (fine.getVehicle() != null) {
                dto.setVehicleId(
                        fine.getVehicle().getId()
                );
            }

            return dto;

        }).collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public FineDto updateFine(FineDto fineDto) {

        if (fineDto.getAmount() == null) {
            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.fine.amount.required"));
        }

        Fine fine = new Fine();

        fine.setId(fineDto.getId());
        fine.setAmount(fineDto.getAmount());
        fine.setReason(fineDto.getReason());
        fine.setPaid(fineDto.getPaid());

        Vehicle vehicle = vehicleRepo.findById(
                fineDto.getVehicleId()
        ).orElse(null);

        fine.setVehicle(vehicle);

        fineRepo.save(fine);

        return fineDto;
    }

    // DELETE
    @Override
    public void deleteFine(Long id) {

        fineRepo.deleteById(id);
    }
}

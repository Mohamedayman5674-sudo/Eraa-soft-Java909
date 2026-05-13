package com.spring.demo.vehicle_registration_system.repo;

import com.spring.demo.vehicle_registration_system.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

}
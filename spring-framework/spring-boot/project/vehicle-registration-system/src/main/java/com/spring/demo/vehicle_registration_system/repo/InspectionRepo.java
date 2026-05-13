package com.spring.demo.vehicle_registration_system.repo;

import com.spring.demo.vehicle_registration_system.entity.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionRepo extends JpaRepository<Inspection, Long> {

}
package com.spring.demo.vehicle_registration_system.repo;

import com.spring.demo.vehicle_registration_system.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepo extends JpaRepository<Fine, Long> {

}
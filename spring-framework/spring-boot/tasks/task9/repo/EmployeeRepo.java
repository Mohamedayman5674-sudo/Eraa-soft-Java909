package com.spring.demo.spring_boot909.task9.repo;

import com.spring.demo.spring_boot909.task9.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByIdIn(List<Long> ids);
    List<Employee> findByNameIn(List<String> names);
}
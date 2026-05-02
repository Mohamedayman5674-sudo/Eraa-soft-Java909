package com.spring.demo.spring_boot909.task7.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.demo.spring_boot909.task7.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // search by name like 'ahmed%'
    List<Employee> findByNameStartingWith(String name);
}
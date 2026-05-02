package com.spring.demo.spring_boot909.task7.service;

import com.spring.demo.spring_boot909.task7.entity.Employee;
import com.spring.demo.spring_boot909.task7.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee save(Employee emp) {
        return repo.save(emp);
    }
}
package com.spring.demo.spring_boot909.task8.service;

import com.spring.demo.spring_boot909.task8.entity.Instructor;
import com.spring.demo.spring_boot909.task8.repo.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository repo;

    public InstructorService(InstructorRepository repo) {
        this.repo = repo;
    }

    public Instructor save(Instructor instructor) {
        return repo.save(instructor);
    }

    public List<Instructor> getAll() {
        return repo.findAll();
    }

    public Instructor getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
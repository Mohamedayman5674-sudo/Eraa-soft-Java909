package com.spring.demo.spring_boot909.task8.controller;

import com.spring.demo.spring_boot909.task8.entity.Instructor;
import com.spring.demo.spring_boot909.task8.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService service;

    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @PostMapping
    public Instructor create(@RequestBody Instructor instructor) {
        return service.save(instructor);
    }

    @GetMapping
    public List<Instructor> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Instructor getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
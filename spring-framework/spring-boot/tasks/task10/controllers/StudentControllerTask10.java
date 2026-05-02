package com.spring.demo.spring_boot909.task10.controllers;

import com.spring.demo.spring_boot909.task10.dtos.StudentDTO;
import com.spring.demo.spring_boot909.task10.services.StudentServiceTask10;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("studentControllerTask10")
@RequestMapping("/task10/students")
@RequiredArgsConstructor
public class StudentControllerTask10 {

    private final StudentServiceTask10 service;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
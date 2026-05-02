package com.spring.demo.spring_boot909.task10.controllers;

import com.spring.demo.spring_boot909.task10.dtos.TeacherDTO;
import com.spring.demo.spring_boot909.task10.services.TeacherServiceTask10;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("teacherController10")
@RequestMapping("/task10/teachers")
@RequiredArgsConstructor
public class TeacherControllerTask10 {

    private final TeacherServiceTask10 service;

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
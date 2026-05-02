package com.spring.demo.spring_boot909.task8.controller;

import com.spring.demo.spring_boot909.task8.entity.Student;
import com.spring.demo.spring_boot909.task8.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public Student register(@PathVariable Long studentId, @PathVariable Long courseId) {
        return service.registerCourse(studentId, courseId);
    }
}
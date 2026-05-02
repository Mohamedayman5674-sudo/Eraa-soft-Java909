package com.spring.demo.spring_boot909.task8.controller;

import com.spring.demo.spring_boot909.task8.entity.Course;
import com.spring.demo.spring_boot909.task8.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @PutMapping("/{courseId}/instructor/{instructorId}")
    public Course assign(@PathVariable Long courseId, @PathVariable Long instructorId) {
        return service.assignInstructor(courseId, instructorId);
    }
}
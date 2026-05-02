package com.spring.demo.spring_boot909.task8.service;

import com.spring.demo.spring_boot909.task8.entity.Course;
import com.spring.demo.spring_boot909.task8.entity.Instructor;
import com.spring.demo.spring_boot909.task8.repo.CourseRepository;
import com.spring.demo.spring_boot909.task8.repo.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepo;
    private final InstructorRepository instructorRepo;

    public CourseService(CourseRepository courseRepo, InstructorRepository instructorRepo) {
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    public Course save(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Course assignInstructor(Long courseId, Long instructorId) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow();

        course.setInstructor(instructor);
        return courseRepo.save(course);
    }
}
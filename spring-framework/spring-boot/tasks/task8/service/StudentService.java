package com.spring.demo.spring_boot909.task8.service;

import com.spring.demo.spring_boot909.task8.entity.Course;
import com.spring.demo.spring_boot909.task8.entity.Student;
import com.spring.demo.spring_boot909.task8.repo.CourseRepository;
import com.spring.demo.spring_boot909.task8.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student getById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    public Student registerCourse(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Course course = courseRepo.findById(courseId).orElseThrow();

        student.getCourses().add(course);
        return studentRepo.save(student);
    }
}
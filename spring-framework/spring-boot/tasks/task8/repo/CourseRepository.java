package com.spring.demo.spring_boot909.task8.repo;

import com.spring.demo.spring_boot909.task8.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
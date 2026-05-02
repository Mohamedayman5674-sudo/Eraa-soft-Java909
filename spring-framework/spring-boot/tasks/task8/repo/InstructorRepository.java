package com.spring.demo.spring_boot909.task8.repo;

import com.spring.demo.spring_boot909.task8.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
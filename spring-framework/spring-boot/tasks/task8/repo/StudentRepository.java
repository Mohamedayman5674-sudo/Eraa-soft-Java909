package com.spring.demo.spring_boot909.task8.repo;

import com.spring.demo.spring_boot909.task8.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
package com.spring.demo.spring_boot909.task10.repo;

import com.spring.demo.spring_boot909.task10.entity.StudentTask10;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepoTask10 extends JpaRepository<StudentTask10, Long> {
}
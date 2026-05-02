package com.spring.demo.spring_boot909.task10.repo;

import com.spring.demo.spring_boot909.task10.entity.TeacherTask10;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepoTask10 extends JpaRepository<TeacherTask10, Long> {
}
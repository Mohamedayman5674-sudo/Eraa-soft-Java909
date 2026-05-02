package com.spring.demo.spring_boot909.task11.repository;

import com.spring.demo.spring_boot909.task11.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
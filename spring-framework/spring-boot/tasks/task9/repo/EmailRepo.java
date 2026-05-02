package com.spring.demo.spring_boot909.task9.repo;

import com.spring.demo.spring_boot909.task9.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailRepo extends JpaRepository<Email, Long> {

    List<Email> findByName(String name);
    List<Email> findByNameIn(List<String> names);
    List<Email> findByContent(String content);
}
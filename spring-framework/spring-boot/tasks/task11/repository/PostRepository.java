package com.spring.demo.spring_boot909.task11.repository;

import com.spring.demo.spring_boot909.task11.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
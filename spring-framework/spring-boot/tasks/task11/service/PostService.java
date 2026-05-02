package com.spring.demo.spring_boot909.task11.service;

import com.spring.demo.spring_boot909.task11.entity.Post;
import com.spring.demo.spring_boot909.task11.entity.User;
import com.spring.demo.spring_boot909.task11.repository.PostRepository;
import com.spring.demo.spring_boot909.task11.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;

    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public Post save(Post post, Long userId) {
        if (userId != null) {
            User user = userRepo.findById(userId).orElseThrow();
            post.setUser(user);
        }
        return postRepo.save(post);
    }

    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public Post findById(Long id) {
        return postRepo.findById(id).orElseThrow();
    }

    public List<Post> findByUserId(Long userId) {
        return postRepo.findByUserId(userId);
    }

    public Post update(Long id, Post post) {
        post.setId(id);
        return postRepo.save(post);
    }

    public void delete(Long id) {
        postRepo.deleteById(id);
    }
}
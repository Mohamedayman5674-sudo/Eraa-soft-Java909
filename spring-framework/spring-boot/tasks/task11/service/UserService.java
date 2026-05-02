package com.spring.demo.spring_boot909.task11.service;

import com.spring.demo.spring_boot909.task11.entity.User;
import com.spring.demo.spring_boot909.task11.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User save(User user) {
        return repo.save(user);
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public User update(Long id, User user) {
        user.setId(id);
        return repo.save(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
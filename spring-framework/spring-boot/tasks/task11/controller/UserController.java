package com.spring.demo.spring_boot909.task11.controller;

import com.spring.demo.spring_boot909.task11.dto.UserDTO;
import com.spring.demo.spring_boot909.task11.mapper.UserMapper;
import com.spring.demo.spring_boot909.task11.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public UserDTO create(@Valid @RequestBody UserDTO dto) {
        return UserMapper.toDTO(service.save(UserMapper.toEntity(dto)));
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return service.findAll().stream().map(UserMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return UserMapper.toDTO(service.findById(id));
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {
        return UserMapper.toDTO(service.update(id, UserMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // 🔥 relations
    @GetMapping("/{id}/posts")
    public List<?> userPosts(@PathVariable Long id) {
        return service.findById(id).getPosts();
    }

    @GetMapping("/usersWithPost")
    public List<?> usersWithPosts() {
        return service.findAll();
    }

    @GetMapping("/userWithPost/{id}")
    public Object userWithPosts(@PathVariable Long id) {
        return service.findById(id);
    }
}
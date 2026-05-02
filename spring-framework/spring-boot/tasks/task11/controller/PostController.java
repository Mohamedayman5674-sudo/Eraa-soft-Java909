package com.spring.demo.spring_boot909.task11.controller;

import com.spring.demo.spring_boot909.task11.dto.PostDTO;
import com.spring.demo.spring_boot909.task11.mapper.PostMapper;
import com.spring.demo.spring_boot909.task11.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public PostDTO create(@Valid @RequestBody PostDTO dto) {
        return PostMapper.toDTO(
                service.save(PostMapper.toEntity(dto), dto.getUserId())
        );
    }

    @GetMapping
    public List<PostDTO> getAll() {
        return service.findAll().stream().map(PostMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public PostDTO getById(@PathVariable Long id) {
        return PostMapper.toDTO(service.findById(id));
    }

    @GetMapping("/user/{userId}")
    public List<PostDTO> getByUser(@PathVariable Long userId) {
        return service.findByUserId(userId).stream().map(PostMapper::toDTO).toList();
    }

    @PutMapping("/{id}")
    public PostDTO update(@PathVariable Long id, @RequestBody PostDTO dto) {
        return PostMapper.toDTO(service.update(id, PostMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // 🔥 relations
    @GetMapping("/postsWithUsers")
    public List<?> postsWithUsers() {
        return service.findAll();
    }

    @GetMapping("/postWithUsers/{id}")
    public Object postWithUser(@PathVariable Long id) {
        return service.findById(id);
    }
}
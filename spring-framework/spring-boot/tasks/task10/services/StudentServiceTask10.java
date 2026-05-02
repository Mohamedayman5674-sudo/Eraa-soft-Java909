package com.spring.demo.spring_boot909.task10.services;

import com.spring.demo.spring_boot909.task10.dtos.StudentDTO;
import com.spring.demo.spring_boot909.task10.entity.StudentTask10;
import com.spring.demo.spring_boot909.task10.mapper.StudentMapper;
import com.spring.demo.spring_boot909.task10.repo.StudentRepoTask10;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceTask10 {

    private final StudentRepoTask10 repo;
    private final StudentMapper mapper;

    public List<StudentDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public StudentDTO getById(Long id) {
        StudentTask10 student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return mapper.toDTO(student);
    }
}
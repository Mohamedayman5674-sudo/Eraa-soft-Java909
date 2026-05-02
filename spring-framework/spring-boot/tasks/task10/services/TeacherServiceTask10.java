package com.spring.demo.spring_boot909.task10.services;

import com.spring.demo.spring_boot909.task10.dtos.TeacherDTO;
import com.spring.demo.spring_boot909.task10.entity.TeacherTask10;
import com.spring.demo.spring_boot909.task10.mapper.TeacherMapper;
import com.spring.demo.spring_boot909.task10.repo.TeacherRepoTask10;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceTask10 {

    private final TeacherRepoTask10 teacherRepo;
    private final TeacherMapper mapper;

    public TeacherServiceTask10(TeacherRepoTask10 teacherRepo, TeacherMapper mapper) {
        this.teacherRepo = teacherRepo;
        this.mapper = mapper;
    }

    public List<TeacherDTO> getAll() {
        return teacherRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList()); // بدل toList()
    }

    public TeacherDTO getById(Long id) {
        TeacherTask10 teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        return mapper.toDTO(teacher);
    }
}
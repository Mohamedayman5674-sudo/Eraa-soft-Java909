package com.spring.demo.spring_boot909.task10.mapper;

import com.spring.demo.spring_boot909.task10.dtos.StudentDTO;
import com.spring.demo.spring_boot909.task10.dtos.TeacherDTO;
import com.spring.demo.spring_boot909.task10.entity.TeacherTask10;
import com.spring.demo.spring_boot909.task10.entity.StudentTask10;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public TeacherDTO toDTO(TeacherTask10 teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());

        dto.setStudents(
                teacher.getStudents()
                        .stream()
                        .map(this::mapStudent)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    private StudentDTO mapStudent(StudentTask10 s) {
        StudentDTO sd = new StudentDTO();
        sd.setId(s.getId());
        sd.setName(s.getName());
        return sd;
    }
}
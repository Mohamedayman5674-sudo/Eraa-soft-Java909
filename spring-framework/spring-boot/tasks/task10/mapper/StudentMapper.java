package com.spring.demo.spring_boot909.task10.mapper;

import com.spring.demo.spring_boot909.task10.dtos.StudentDTO;
import com.spring.demo.spring_boot909.task10.dtos.TeacherSimpleDTO;
import com.spring.demo.spring_boot909.task10.entity.StudentTask10;
import com.spring.demo.spring_boot909.task10.entity.TeacherTask10;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public StudentDTO toDTO(StudentTask10 student) {

        if (student == null) {
            return null;
        }

        StudentDTO dto = new StudentDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());

        // تحويل teachers
        if (student.getTeachers() != null) {
            dto.setTeachers(
                    student.getTeachers()
                            .stream()
                            .map(t -> {
                                TeacherSimpleDTO td = new TeacherSimpleDTO();
                                td.setId(t.getId());
                                td.setName(t.getName());
                                return td;
                            })
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
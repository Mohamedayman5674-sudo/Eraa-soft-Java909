package com.spring.demo.spring_boot909.task10.dtos;

import lombok.Data;
import java.util.List;

@Data
public class TeacherDTO {
    private Long id;
    private String name;
    private List<StudentDTO> students;
}
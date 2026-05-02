package com.spring.demo.spring_boot909.task10.dtos;

import lombok.Data;
import java.util.List;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private List<TeacherSimpleDTO> teachers;
}
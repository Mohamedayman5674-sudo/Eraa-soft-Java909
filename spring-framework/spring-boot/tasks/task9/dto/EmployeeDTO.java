package com.spring.demo.spring_boot909.task9.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 16, message = "Age must be > 15")
    @Max(value = 39, message = "Age must be < 40")
    private int age;

    @Min(value = 5001, message = "Salary must be > 5000")
    @Max(value = 9999, message = "Salary must be < 10000")
    private double salary;

    private List<EmailDTO> emails;
}
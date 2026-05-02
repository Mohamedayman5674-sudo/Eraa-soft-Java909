package com.spring.demo.spring_boot909.task9.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmailDTO {

    private Long id;

    @NotBlank(message = "Type is required")
    private String name;

    @Email(message = "Invalid email format")
    private String content;
}
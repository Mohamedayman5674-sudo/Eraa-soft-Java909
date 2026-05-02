package com.spring.demo.spring_boot909.task11.dto;

import jakarta.validation.constraints.*;

public class UserDTO {

    private Long id;

    @Size(min = 7, message = "Name must be more than 7 characters")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$",
            message = "Password must contain upper, lower, number and special char"
    )
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
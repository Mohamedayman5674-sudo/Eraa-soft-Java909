package com.spring.demo.spring_boot909.task11.dto;

import jakarta.validation.constraints.*;

public class PostDTO {

    private Long id;

    @NotNull
    @Size(min = 20, message = "Text must be at least 20 characters")
    private String text;

    private String imagePath;

    private Long userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
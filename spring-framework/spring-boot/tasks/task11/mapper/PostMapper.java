package com.spring.demo.spring_boot909.task11.mapper;

import com.spring.demo.spring_boot909.task11.dto.PostDTO;
import com.spring.demo.spring_boot909.task11.entity.Post;

public class PostMapper {

    public static Post toEntity(PostDTO dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setText(dto.getText());
        post.setImagePath(dto.getImagePath());
        return post;
    }

    public static PostDTO toDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setText(post.getText());
        dto.setImagePath(post.getImagePath());
        if (post.getUser() != null) {
            dto.setUserId(post.getUser().getId());
        }
        return dto;
    }
}
package com.spring.demo.spring_boot909.task11.mapper;

import com.spring.demo.spring_boot909.task11.dto.UserDTO;
import com.spring.demo.spring_boot909.task11.entity.User;

public class UserMapper {

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setAge(user.getAge());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
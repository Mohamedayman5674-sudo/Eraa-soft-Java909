package com.spring.demo.vehicle_registration_system.service;

import com.spring.demo.vehicle_registration_system.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);

}
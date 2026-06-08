package com.spring.demo.vehicle_registration_system.service.impl;

import com.spring.demo.vehicle_registration_system.dto.UserDto;
import com.spring.demo.vehicle_registration_system.entity.User;
import com.spring.demo.vehicle_registration_system.helper.BundleMessageService;
import com.spring.demo.vehicle_registration_system.repo.UserRepo;
import com.spring.demo.vehicle_registration_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final BundleMessageService bundleMessageService;

    @Autowired
    public UserServiceImpl(
            UserRepo userRepo,
            BundleMessageService bundleMessageService) {

        this.userRepo = userRepo;
        this.bundleMessageService = bundleMessageService;
    }

    // CREATE
    @Override
    public UserDto createUser(UserDto userDto) {

        if (userDto.getName() == null
                || userDto.getName().isBlank()) {

            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.user.name.required"));
        }

        if (userDto.getEmail() == null
                || userDto.getEmail().isBlank()) {

            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.user.email.required"));
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        user = userRepo.save(user);

        userDto.setId(user.getId());

        return userDto;
    }

    // GET BY ID
    @Override
    public UserDto getUserById(Long id) {

        User user = userRepo.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());

        return dto;
    }

    // GET ALL
    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepo.findAll();

        return users.stream().map(user -> {

            UserDto dto = new UserDto();

            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setPhone(user.getPhone());

            return dto;

        }).collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public UserDto updateUser(UserDto userDto) {

        if (userDto.getName() == null
                || userDto.getName().isBlank()) {

            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.user.name.required"));
        }

        if (userDto.getEmail() == null
                || userDto.getEmail().isBlank()) {

            throw new RuntimeException(
                    bundleMessageService.getMessage(
                            "error.user.email.required"));
        }

        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        userRepo.save(user);

        return userDto;
    }

    // DELETE
    @Override
    public void deleteUser(Long id) {

        userRepo.deleteById(id);
    }
}

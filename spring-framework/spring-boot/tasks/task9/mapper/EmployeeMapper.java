package com.spring.demo.spring_boot909.task9.mapper;

import com.spring.demo.spring_boot909.task9.dto.*;
import com.spring.demo.spring_boot909.task9.entity.*;

import java.util.stream.Collectors;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setId(dto.getId());
        emp.setName(dto.getName());
        emp.setAge(dto.getAge());
        emp.setSalary(dto.getSalary());

        if (dto.getEmails() != null) {
            emp.setEmails(dto.getEmails().stream().map(e -> {
                Email email = new Email();
                email.setName(e.getName());
                email.setContent(e.getContent());
                email.setEmployee(emp);
                return email;
            }).collect(Collectors.toList()));
        }

        return emp;
    }

    public static EmployeeDTO toDTO(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setAge(emp.getAge());
        dto.setSalary(emp.getSalary());

        if (emp.getEmails() != null) {
            dto.setEmails(emp.getEmails().stream().map(e -> {
                EmailDTO ed = new EmailDTO();
                ed.setId(e.getId());
                ed.setName(e.getName());
                ed.setContent(e.getContent());
                return ed;
            }).collect(Collectors.toList()));
        }

        return dto;
    }
}
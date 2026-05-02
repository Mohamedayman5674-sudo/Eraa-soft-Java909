package com.spring.demo.spring_boot909.task9.service;

import com.spring.demo.spring_boot909.task9.dto.EmployeeDTO;
import com.spring.demo.spring_boot909.task9.entity.Employee;
import com.spring.demo.spring_boot909.task9.mapper.EmployeeMapper;
import com.spring.demo.spring_boot909.task9.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
 public class EmployeeServiceTask9 {

    private final EmployeeRepo repo;

    public EmployeeServiceTask9(EmployeeRepo repo) {
        this.repo = repo;
    }

    public EmployeeDTO save(EmployeeDTO dto) {
        Employee emp = EmployeeMapper.toEntity(dto);
        return EmployeeMapper.toDTO(repo.save(emp));
    }

    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee emp = repo.findById(id).orElseThrow();
        emp.setName(dto.getName());
        emp.setAge(dto.getAge());
        emp.setSalary(dto.getSalary());
        return EmployeeMapper.toDTO(repo.save(emp));
    }

    public List<EmployeeDTO> getAll() {
        return repo.findAll().stream()
                .map(EmployeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getById(Long id) {
        return EmployeeMapper.toDTO(repo.findById(id).orElseThrow());
    }

    public List<EmployeeDTO> getByIds(List<Long> ids) {
        return repo.findByIdIn(ids)
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    public List<EmployeeDTO> getByNames(List<String> names) {
        return repo.findByNameIn(names)
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
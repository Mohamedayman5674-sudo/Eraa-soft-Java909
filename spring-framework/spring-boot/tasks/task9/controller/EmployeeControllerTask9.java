package com.spring.demo.spring_boot909.task9.controller;
import com.spring.demo.spring_boot909.task9.dto.EmployeeDTO;
import com.spring.demo.spring_boot909.task9.service.EmployeeServiceTask9;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task9/employees")
public class EmployeeControllerTask9 {

     private final EmployeeServiceTask9 service;

    public EmployeeControllerTask9(EmployeeServiceTask9  service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.status(201).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable Long id,
                                              @Valid @RequestBody EmployeeDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/ids")
    public ResponseEntity<List<EmployeeDTO>> getByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(service.getByIds(ids));
    }

    @GetMapping("/names")
    public ResponseEntity<List<EmployeeDTO>> getByNames(@RequestParam List<String> names) {
        return ResponseEntity.ok(service.getByNames(names));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
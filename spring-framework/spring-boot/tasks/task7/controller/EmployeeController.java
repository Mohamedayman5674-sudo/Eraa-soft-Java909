package com.spring.demo.spring_boot909.task7.controller;

import com.spring.demo.spring_boot909.task7.entity.Employee;
import com.spring.demo.spring_boot909.task7.repo.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    // ✅ get all employees
    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    // ✅ get employee by list of ids
    @PostMapping("/ids")
    public List<Employee> getByIds(@RequestBody List<Long> ids) {
        return repo.findAllById(ids);
    }

    // ✅ save employee
    @PostMapping
    public Employee save(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    // ✅ save list of employees
    @PostMapping("/list")
    public List<Employee> saveList(@RequestBody List<Employee> list) {
        return repo.saveAll(list);
    }

    // ✅ update employee
    @PutMapping
    public Employee update(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    // ✅ update list
    @PutMapping("/list")
    public List<Employee> updateList(@RequestBody List<Employee> list) {
        return repo.saveAll(list);
    }

    // ✅ delete all
    @DeleteMapping
    public void deleteAll() {
        repo.deleteAll();
    }

    // ✅ delete by id
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // ✅ delete by list of ids
    @DeleteMapping("/ids")
    public void deleteByIds(@RequestBody List<Long> ids) {
        repo.deleteAllById(ids);
    }

    // ✅ search by name like 'ahmed%'
    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return repo.findByNameStartingWith(name);
    }
}
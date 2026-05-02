package com.spring.demo.spring_boot909.task9.controller;

import com.spring.demo.spring_boot909.task9.entity.Email;
import com.spring.demo.spring_boot909.task9.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Email> create(@RequestBody Email email) {
        return ResponseEntity.status(201).body(service.save(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Email> update(@PathVariable Long id, @RequestBody Email email) {
        return ResponseEntity.ok(service.update(id, email));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Email>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/name")
    public ResponseEntity<List<Email>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(service.getByName(name));
    }

    @GetMapping("/names")
    public ResponseEntity<List<Email>> getByNames(@RequestParam List<String> names) {
        return ResponseEntity.ok(service.getByNames(names));
    }

    @GetMapping("/content")
    public ResponseEntity<List<Email>> getByContent(@RequestParam String content) {
        return ResponseEntity.ok(service.getByContent(content));
    }
}
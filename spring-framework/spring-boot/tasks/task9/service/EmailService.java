package com.spring.demo.spring_boot909.task9.service;

import com.spring.demo.spring_boot909.task9.entity.Email;
import com.spring.demo.spring_boot909.task9.repo.EmailRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private final EmailRepo repo;

    public EmailService(EmailRepo repo) {
        this.repo = repo;
    }

    public Email save(Email email) {
        return repo.save(email);
    }

    public Email update(Long id, Email email) {
        Email e = repo.findById(id).orElseThrow();
        e.setName(email.getName());
        e.setContent(email.getContent());
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Email> getAll() {
        return repo.findAll();
    }

    public List<Email> getByName(String name) {
        return repo.findByName(name);
    }

    public List<Email> getByNames(List<String> names) {
        return repo.findByNameIn(names);
    }

    public List<Email> getByContent(String content) {
        return repo.findByContent(content);
    }
}
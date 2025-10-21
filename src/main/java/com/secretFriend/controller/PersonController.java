package com.secretFriend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secretFriend.model.Person;
import com.secretFriend.service.PersonService;
import com.secretFriend.service.SecretSantaService;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "*")
public class PersonController {
    private final PersonService service;
    private final SecretSantaService secretSanta;

    public PersonController(PersonService service, SecretSantaService secretSanta) {
        this.service = service;
        this.secretSanta = secretSanta;
    }

    @GetMapping
    public List<Person> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person p) {
        return service.save(p);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable String id, @RequestBody Person p) {
        p.setId(id);
        return service.save(p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/draw")
    public void draw() {
        secretSanta.performDraw();
    }
}

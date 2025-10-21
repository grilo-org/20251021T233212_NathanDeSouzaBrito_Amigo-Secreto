package com.secretFriend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.secretFriend.model.Person;
import com.secretFriend.repository.PersonRepository;

@Service
public class PersonService {
    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public List<Person> findAll() {
        return repo.findAll();
    }

    public Person save(Person p) {
        return repo.save(p);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}

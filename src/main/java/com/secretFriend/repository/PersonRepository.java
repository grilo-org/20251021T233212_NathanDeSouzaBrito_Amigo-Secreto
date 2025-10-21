package com.secretFriend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.secretFriend.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
}

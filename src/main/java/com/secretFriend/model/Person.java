package com.secretFriend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "persons")
public class Person {
    @Id
    private String id;
    private String name;
    private String email;
}

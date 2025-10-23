package com.example.userservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Long id;
    private String name;
    private String email;

    public User() {
        this.id = System.currentTimeMillis(); // ensure default ID if no args
    }

    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("email") String email) {
        this.id = System.currentTimeMillis(); // always set when created
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

package com.example.coffee.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Member {
    @Id
    private String userId;
    private String password;

    public Member() {
    }

    public Member(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
